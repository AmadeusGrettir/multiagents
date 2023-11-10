package weeklyTasks.EnglishAuction.organizerFSM;

import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import weeklyTasks.EnglishAuction.TopicHelper;

import java.util.List;
import java.util.Random;

public class StartAuctionOneShotBehaviour extends OneShotBehaviour {

    private List<AID> ags;

    public StartAuctionOneShotBehaviour(List<AID> agentNames) {
        this.ags = agentNames;
    }
    @Override
    public void action() {
        //String topicName = "topic_"+new Random().nextLong(1000000000);
        //TopicHelper.register(myAgent, topicName);
        ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
        //msg.setContent(topicName);
        msg.setProtocol("Auction");
        ags.forEach(e -> msg.addReceiver(e));
        myAgent.send(msg);
    }
}
