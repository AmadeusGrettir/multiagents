package weeklyTasks.EnglishAuction.participiantFSM;

import jade.core.behaviours.Behaviour;
import jade.core.behaviours.ParallelBehaviour;
import jade.core.behaviours.WakerBehaviour;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WaitForContractParallelBehaviour extends ParallelBehaviour {
    private Behaviour wakeupBeh;
    private ReceiveContractBehaviour receiveBeh;

    public WaitForContractParallelBehaviour() {
        super(WHEN_ANY);
    }

    @Override
    public void onStart() {
        receiveBeh = new ReceiveContractBehaviour();
        wakeupBeh = new WakerBehaviour(myAgent, 10000){
            boolean wake = false;
            @Override
            protected void onWake() {
                wake = true;
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
                return 0;
            } else {
                return 1;
            }
        } else {
            if (receiveBeh.onEnd() == 1) {
                log.info("I'm a winner");
                return  1;
            } else {
                log.info("I'm a looser");
                return 0;
            }
        }
    }
}
