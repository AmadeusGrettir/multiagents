package weeklyTasks.EnglishAuction.participiantFSM;

import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SendContractOneShotBehaviour extends OneShotBehaviour {

    // 1 or 0
    private final int logicInt = (int) Math.floor(Math.random() * 2);

    @Override
    public void action() {
        ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
        msg.addReceiver(new AID("organizer", false));
        if (logicInt == 1) {
            msg.setContent("accept");
        } else {
            msg.setContent("refuse");
        }
        myAgent.send(msg);
    }

    @Override
    public int onEnd() {
        if (logicInt == 1){
            log.info("I'll pay for it");
            return 1;
        } else {
            log.info("I'm out");
            return 0;
        }
    }
}
