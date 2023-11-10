package weeklyTasks.EnglishAuction;

import jade.core.behaviours.FSMBehaviour;
import weeklyTasks.EnglishAuction.organizerFSM.*;

public class OrganizerFSMBehaviour extends FSMBehaviour {
    private final String FIRST_STATE = "firstState";
    private final String WAIT_PROPOSES ="waitProps";
    private final String WAIT_ACCEPT ="waitAccept";
    private final String SUCCESS ="success";
    private final String FAIL ="fail";

    @Override
    public void onStart() {
        var receivers = DfHelper.search(myAgent, "selling_books");
        this.registerFirstState(new StartAuctionOneShotBehaviour(receivers), FIRST_STATE);
        this.registerState(new WaitForProposesParallelBehaviour(receivers.size()), WAIT_PROPOSES);
        this.registerState(new WaitForAcceptContractParallelBehaviour(), WAIT_ACCEPT);
        this.registerLastState(new Fail(), FAIL);
        this.registerLastState(new Success(), SUCCESS);

        this.registerDefaultTransition(FIRST_STATE, WAIT_PROPOSES);
        this.registerTransition(WAIT_PROPOSES, FAIL, 0);
        this.registerTransition(WAIT_PROPOSES, WAIT_ACCEPT, 1);
        this.registerTransition(WAIT_ACCEPT, FAIL, 0);
        this.registerTransition(WAIT_ACCEPT, SUCCESS, 1);
    }
}
