package usantatecla.tictactoe.launchers.server.dispatchers.save;

import usantatecla.tictactoe.controllers.implementation.PlayControllerImplementation;
import usantatecla.tictactoe.launchers.server.dispatchers.core.Dispatcher;

public class NextDispatcher extends Dispatcher {

	public NextDispatcher(PlayControllerImplementation playControllerImplementation) {
		super(playControllerImplementation);
	}

	@Override
	public void dispatch() {
		((PlayControllerImplementation) this.acceptorController).next();
	}

}
