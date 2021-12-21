package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.views.Message;
import usantatecla.utils.views.YesNoDialog;

public class ResumeView implements usantatecla.tictactoe.views.ResumeView {

    public boolean read() {
        YesNoDialog isResumed = new YesNoDialog();
        isResumed.read(Message.RESUME.toString());
        return isResumed.isAffirmative();
    }

}
