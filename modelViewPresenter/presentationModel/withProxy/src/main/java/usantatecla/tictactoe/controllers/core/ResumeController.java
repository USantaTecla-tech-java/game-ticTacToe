package usantatecla.tictactoe.controllers.core;

import usantatecla.tictactoe.models.Session;

public abstract class ResumeController extends AcceptorController {

	public ResumeController(Session session) {
		super(session);
	}

	public abstract void resume(boolean newGame);

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}

}
