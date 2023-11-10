package weeklyTasks.EnglishAuction.organizerFSM;

import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class ReceiveAcceptBehaviour extends Behaviour {
    private boolean accepted = false;
    private boolean received = false;


    @Override
    public void action() {
        ACLMessage propose = myAgent.receive(MessageTemplate.MatchPerformative(ACLMessage.INFORM));
        if (propose != null) {
            received = true;
            String answer = propose.getContent();
            if (answer.equals("accept")){
                accepted = true;
            } else if (answer.equals("refuse")){
                accepted = false;
            }
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
        return accepted ? 1 : 0;
    }

}

