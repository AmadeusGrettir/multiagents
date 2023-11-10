package weeklyTasks.EnglishAuction.participiantFSM;

import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public class SendAnswerOneShotBehaviour extends OneShotBehaviour {
    // 1 or 0
    private final int randomInt = (int) Math.floor(Math.random() * 2);
    @Override
    public void action() {
        if (randomInt == 1) {
            ACLMessage msg = new ACLMessage(ACLMessage.PROPOSE);
            msg.addReceiver(new AID("organizer", false));
            int bet = (int) (Math.random() * 100) + 100;
            msg.setContent(String.valueOf(bet));
            myAgent.send(msg);
        }
    }

    @Override
    public int onEnd() {
        if (randomInt == 1) {
            return 1;
        } else {
            return 0;
        }
    }
}
