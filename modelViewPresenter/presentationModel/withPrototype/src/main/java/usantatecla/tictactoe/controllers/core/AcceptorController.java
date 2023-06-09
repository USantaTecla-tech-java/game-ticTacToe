package usantatecla.tictactoe.controllers.core;

import usantatecla.tictactoe.models.core.Session;

public abstract class AcceptorController extends Controller {
    
    AcceptorController(Session session) {
		super(session);
	}

	public abstract void accept(ControllersVisitor controllersVisitor);
}