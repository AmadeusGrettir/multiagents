package weeklyTasks.EnglishAuction.participiantFSM;

import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class ReceiveContractBehaviour extends Behaviour {
    private boolean agraccepted = false;
    private boolean refaccepted = false;
    private boolean received = false;


    @Override
    public void action() {
        ACLMessage agr = myAgent.receive(MessageTemplate.MatchPerformative(ACLMessage.AGREE));
        ACLMessage ref = myAgent.receive(MessageTemplate.MatchPerformative(ACLMessage.REFUSE));
        if (agr != null) {
            received = true;
            agraccepted = true;
        } else if (ref != null) {
            received = true;
            refaccepted = true;
        } else {
            block();
        }
    }

    @Override
    public boolean done() {
        return received;
    }

    @Override
    public int onEnd() {
        if (agraccepted == true) {
            return 1;
        } else {
            return 0;
        }
    }

}

