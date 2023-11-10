package weeklyTasks.EnglishAuction.participiantFSM;

import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class WaitForIniviteBehaviour extends Behaviour {

    private boolean received = false;

    @Override
    public void action() {
        ACLMessage receivedMSG = myAgent.receive(MessageTemplate.MatchPerformative(ACLMessage.REQUEST));

        if (receivedMSG != null){
            received = true;
        } else {
            block();
        }
    }

    @Override
    public boolean done() {
        return received;
    }
}
