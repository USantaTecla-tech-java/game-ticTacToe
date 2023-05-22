package usantatecla.tictactoe.distributed.server.dispatchers.save;

import usantatecla.tictactoe.controllers.implementation.SaveControllerImplementation;
import usantatecla.tictactoe.distributed.server.dispatchers.Dispatcher;

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
