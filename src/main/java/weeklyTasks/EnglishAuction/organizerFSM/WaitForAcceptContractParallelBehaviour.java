package weeklyTasks.EnglishAuction.organizerFSM;

import jade.core.behaviours.Behaviour;
import jade.core.behaviours.ParallelBehaviour;
import jade.core.behaviours.WakerBehaviour;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class WaitForAcceptContractParallelBehaviour extends ParallelBehaviour {
    private Behaviour wakeupBeh;
    private ReceiveAcceptBehaviour receiveBeh;

    public WaitForAcceptContractParallelBehaviour() {
        super(WHEN_ANY);
    }

    @Override
    public void onStart() {
        receiveBeh = new ReceiveAcceptBehaviour();
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
        if (wakeupBeh.done()) {
            if (receiveBeh.onEnd() == 0) {
                log.info("No appropriate answer was received");
                return 0;
            } else {
                return 1;
            }
        } else {
            if (receiveBeh.onEnd() == 1) {
                log.info("Winner will pay the bet");
                return  1;
            } else {
                log.info("Winner won't pay the bet");
                return 0;
            }
        }
    }
}

