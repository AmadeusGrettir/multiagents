package weeklyTasks.EnglishAuction;

import jade.core.Agent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AgentParticipant extends Agent {
    @Override
    protected void setup() {
        DfHelper.register(this, "selling_books");
        log.info("Hi");
        addBehaviour(new ParticipantFSMBehaviour());
    }
}
