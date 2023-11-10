package weeklyTasks.EnglishAuction.organizerFSM;

import jade.core.behaviours.Behaviour;
import jade.core.behaviours.ParallelBehaviour;
import jade.core.behaviours.WakerBehaviour;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class WaitForProposesParallelBehaviour extends ParallelBehaviour {
    private int participantsCount;
    private Behaviour wakeupBeh;
    private ReceiveProposesBehaviour receiveBeh;

    public WaitForProposesParallelBehaviour(int participantsCount) {
        super(WHEN_ANY);
        this.participantsCount = participantsCount;
    }

    @Override
    public void onStart() {
        receiveBeh = new ReceiveProposesBehaviour(participantsCount);
        wakeupBeh = new WakerBehaviour(myAgent, 5000){
            boolean wake = false;
            @Override
            protected void onWake() {
                wake = true;
                log.info("TIME IS UP");
            }

            @Override
            public int onEnd() {
                return wake ? 0 : 1;
            }
        };
        this.addSubBehaviour(receiveBeh);
        this.addSubBehaviour(wakeupBeh);
    }

    @Override
    public int onEnd() {
        //badway == 0, good way == 1;
        if (wakeupBeh.done()) {
            if (receiveBeh.onEnd() == 0) {
                log.info("No appropriate offer was received");
                return 0;
            } else {
                log.info("There is a winner");
                myAgent.addBehaviour(new SendContractOneShotBehaviour(receiveBeh.getAnswers(), receiveBeh.getBestOffer()));
                return 1;
            }
        } else {
            if (receiveBeh.getBestOffer() != null) {
                log.info("There is a winner");
                myAgent.addBehaviour(new SendContractOneShotBehaviour(receiveBeh.getAnswers(), receiveBeh.getBestOffer()));
                return  1;
            } else {
                log.info("No appropriate offer was received");
                return 0;
            }
        }
    }
}
