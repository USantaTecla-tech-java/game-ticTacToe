package usantatecla.tictactoe.controllers.core;

import usantatecla.tictactoe.models.core.Session;
import usantatecla.tictactoe.models.core.SessionImplementation;

public class ExitController extends Controller {

	public ExitController(Session session) {
		super(session);
	}

	public void next() {
		((SessionImplementation) this.session).next();
	}

}
