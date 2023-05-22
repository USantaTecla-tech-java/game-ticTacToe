package usantatecla.tictactoe.controllers.interfaces;

import usantatecla.tictactoe.controllers.Controller;
import usantatecla.tictactoe.models.Session;
import usantatecla.tictactoe.models.SessionImplementation;

public class ExitController extends Controller {

	public ExitController(Session session) {
		super(session);
	}

	public void next() {
		((SessionImplementation) this.session).next();
	}

}
