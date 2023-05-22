package usantatecla.tictactoe.views;

import usantatecla.tictactoe.controllers.interfaces.ResumeController;
import usantatecla.tictactoe.views.models.MessageView;
import usantatecla.utils.YesNoDialog;

class ResumeView {

	void interact(ResumeController resumeController) {
		resumeController.resume(new YesNoDialog().read(MessageView.RESUME.getMessage()));
	}

}
