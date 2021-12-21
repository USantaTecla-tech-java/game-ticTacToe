package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.ResumeController;
import usantatecla.tictactoe.views.Message;
import usantatecla.utils.views.YesNoDialog;

class ResumeView {

    private ResumeController resumeController;

    ResumeView(ResumeController resumeController) {
        this.resumeController = resumeController;
    }

    boolean interact() {
        YesNoDialog isResumed = new YesNoDialog();
        isResumed.read(Message.RESUME.toString());
        if (isResumed.isAffirmative()) {
            this.resumeController.reset();
        }
        return isResumed.isAffirmative();
    }

}
