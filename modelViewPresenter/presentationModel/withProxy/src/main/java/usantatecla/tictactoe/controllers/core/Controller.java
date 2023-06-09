package usantatecla.tictactoe.controllers.core;

import usantatecla.tictactoe.models.Session;
import usantatecla.tictactoe.types.StateValue;

public abstract class Controller {
    
	protected Session session;

	protected Controller(Session session) {
		this.session = session;
	}

	public StateValue getValueState() {
		return this.session.getValueState();
	}
}