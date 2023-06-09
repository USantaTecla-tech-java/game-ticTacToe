package usantatecla.tictactoe.controllers.core;

import usantatecla.tictactoe.models.core.Session;
import usantatecla.tictactoe.models.types.StateValue;

public abstract class Controller {
    
	protected Session session;

	Controller(Session session) {
		this.session = session;
	}

	public StateValue getValueState() {
		return this.session.getValueState();
	}
}