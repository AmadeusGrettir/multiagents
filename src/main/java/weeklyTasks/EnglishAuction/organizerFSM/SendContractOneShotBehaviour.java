package weeklyTasks.EnglishAuction.organizerFSM;

import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import weeklyTasks.EnglishAuction.TopicHelper;

import java.util.List;
import java.util.Random;

public class SendContractOneShotBehaviour extends OneShotBehaviour {

    private final List<ACLMessage> agents;
    private final ACLMessage winner;

    public SendContractOneShotBehaviour(List<ACLMessage> receivers, ACLMessage bestOffer) {
        this.agents = receivers;
        this.winner = bestOffer;
    }


    @Override
    public void action() {
        agents.remove(winner);

        //String failTopicName = "topic_"+new Random().nextLong(1000000000);
        //TopicHelper.register(myAgent, failTopicName);
        ACLMessage failMSG = new ACLMessage(ACLMessage.REFUSE);
        //failMSG.setContent(failTopicName);
        failMSG.setProtocol("Auction");
        agents.forEach(e -> failMSG.addReceiver(e.getSender()));
        myAgent.send(failMSG);

        //String successTopicName = "topic_"+new Random().nextLong(1000000000);
        //TopicHelper.register(myAgent, successTopicName);
        ACLMessage successMSG = new ACLMessage(ACLMessage.AGREE);
        //successMSG.setContent(successTopicName);
        successMSG.setProtocol("Auction");
        successMSG.addReceiver(winner.getSender());
        myAgent.send(successMSG);

    }
}
