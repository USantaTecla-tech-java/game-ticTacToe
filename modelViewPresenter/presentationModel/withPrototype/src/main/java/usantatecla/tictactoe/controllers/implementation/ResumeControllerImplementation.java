package usantatecla.tictactoe.controllers.implementation;

import usantatecla.tictactoe.controllers.core.ResumeController;
import usantatecla.tictactoe.models.core.Session;
import usantatecla.tictactoe.models.core.SessionImplementation;

public class ResumeControllerImplementation extends ResumeController {

	private SessionImplementation sessionImplementation;

	public ResumeControllerImplementation(Session session) {
		super(session);
		this.sessionImplementation = ((SessionImplementation) this.session);
	}

	public void resume(boolean newGame) {
		if (newGame) {
			this.sessionImplementation.newGame();
		} else {
			this.sessionImplementation.next();
		}
	}

}
