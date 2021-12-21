package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.views.Message;
import usantatecla.tictactoe.views.WithLogicView;
import usantatecla.utils.views.YesNoDialog;

class ResumeView extends WithLogicView {

    ResumeView(Logic logic) {
        super(logic);
    }

    boolean interact() {
        YesNoDialog isResumed = new YesNoDialog();
        isResumed.read(Message.RESUME.toString());
        if (isResumed.isAffirmative()) {
            this.logic.reset();
        }
        return isResumed.isAffirmative();
    }

}
