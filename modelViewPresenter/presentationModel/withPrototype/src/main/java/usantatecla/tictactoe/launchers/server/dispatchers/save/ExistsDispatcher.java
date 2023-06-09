package usantatecla.tictactoe.launchers.server.dispatchers.save;

import usantatecla.tictactoe.controllers.implementation.SaveControllerImplementation;
import usantatecla.tictactoe.launchers.server.dispatchers.core.Dispatcher;

public class ExistsDispatcher extends Dispatcher {

	public ExistsDispatcher(SaveControllerImplementation saveControllerImplementation) {
		super(saveControllerImplementation);
	}

	@Override
	public void dispatch() {
		String name = this.tcpip.receiveLine();
		this.tcpip.send(((SaveControllerImplementation) this.acceptorController).exists(name));
	}

}
