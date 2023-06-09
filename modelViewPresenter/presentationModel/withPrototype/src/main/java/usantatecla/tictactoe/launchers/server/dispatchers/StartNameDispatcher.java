package usantatecla.tictactoe.launchers.server.dispatchers;

import usantatecla.tictactoe.controllers.implementation.StartControllerImplementation;
import usantatecla.tictactoe.launchers.server.dispatchers.core.Dispatcher;

public class StartNameDispatcher extends Dispatcher {

	public StartNameDispatcher(StartControllerImplementation startControllerImplementation) {
		super(startControllerImplementation);
	}

	@Override
	public void dispatch() {
		String title = this.tcpip.receiveLine();
		((StartControllerImplementation) this.acceptorController).start(title);
	}

}
