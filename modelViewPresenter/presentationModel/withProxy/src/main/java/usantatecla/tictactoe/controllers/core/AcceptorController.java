package usantatecla.tictactoe.controllers.core;

import usantatecla.tictactoe.models.Session;

public abstract class AcceptorController extends Controller {
    
    protected AcceptorController(Session session) {
		super(session);
	}

	public abstract void accept(ControllersVisitor controllersVisitor);
}