package usantatecla.tictactoe.launchers.server.dispatchers;

import usantatecla.tictactoe.controllers.interfaces.StartController;

public class StartDispatcher extends Dispatcher {

	public StartDispatcher(StartController startController) {
		super(startController);
	}

	@Override
	public void dispatch() {
		((StartController) this.acceptorController).start();
	}

}
