package weeklyTasks.EnglishAuction;

import jade.core.Agent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AgentOrganizer extends Agent {
    @Override
    protected void setup() {
        DfHelper.register(this, "auction_master");
        log.info("Hayay");
        addBehaviour(new OrganizerFSMBehaviour());
    }
}
