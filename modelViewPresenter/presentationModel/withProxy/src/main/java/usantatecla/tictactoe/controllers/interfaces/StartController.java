package usantatecla.tictactoe.controllers.interfaces;

import usantatecla.tictactoe.controllers.AcceptorController;
import usantatecla.tictactoe.controllers.ControllersVisitor;
import usantatecla.tictactoe.models.Session;

public abstract class StartController extends AcceptorController {
    
    public StartController(Session session) {
		super(session);
	}

	public abstract void start();

	public abstract void createPlayers(int numberOfUsers);

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}
}