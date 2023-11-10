package weeklyTasks.EnglishAuction;

import jade.core.behaviours.FSMBehaviour;
import weeklyTasks.EnglishAuction.participiantFSM.*;

public class ParticipantFSMBehaviour extends FSMBehaviour {
    private final String WAIT_INVITE ="waitInvite";
    private final String SEND_ANSWER ="sendAnswer";
    private final String WAIT_CONTRACT ="waitContract";
    private final String SEND_CONTRACT ="sendContract";
    private final String SUCCESS ="success";
    private final String FAIL ="fail";

    @Override
    public void onStart() {
        this.registerFirstState(new WaitForIniviteBehaviour(), WAIT_INVITE);
        this.registerState(new SendAnswerOneShotBehaviour(), SEND_ANSWER);
        this.registerState(new WaitForContractParallelBehaviour(), WAIT_CONTRACT);
        this.registerState(new SendContractOneShotBehaviour(), SEND_CONTRACT);
        this.registerLastState(new Fail(), FAIL);
        this.registerLastState(new Success(), SUCCESS);

        this.registerDefaultTransition(WAIT_INVITE, SEND_ANSWER);
        this.registerTransition(SEND_ANSWER, FAIL, 0);
        this.registerTransition(SEND_ANSWER, WAIT_CONTRACT, 1);
        this.registerTransition(WAIT_CONTRACT, FAIL, 0);
        this.registerTransition(WAIT_CONTRACT, SEND_CONTRACT, 1);
        this.registerTransition(SEND_CONTRACT, FAIL, 0);
        this.registerTransition(SEND_CONTRACT, SUCCESS, 1);
    }
}
