package usantatecla.tictactoe.views;

import usantatecla.tictactoe.controllers.core.ResumeController;
import usantatecla.utils.YesNoDialog;

class ResumeView {

	void interact(ResumeController resumeController) {
		resumeController.resume(new YesNoDialog().read(MessageView.RESUME.getMessage()));
	}

}
