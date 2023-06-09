package usantatecla.tictactoe.views.console.core;

import usantatecla.tictactoe.controllers.core.ResumeController;
import usantatecla.tictactoe.views.console.models.MessageView;
import usantatecla.utils.YesNoDialog;

class ResumeView {

	void interact(ResumeController resumeController) {
		resumeController.resume(new YesNoDialog().read(MessageView.RESUME.getMessage()));
	}

}
