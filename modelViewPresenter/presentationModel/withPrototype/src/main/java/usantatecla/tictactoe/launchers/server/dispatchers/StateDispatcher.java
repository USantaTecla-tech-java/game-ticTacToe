package usantatecla.tictactoe.launchers.server.dispatchers;

import usantatecla.tictactoe.controllers.core.PlayController;
import usantatecla.tictactoe.launchers.server.dispatchers.core.Dispatcher;

public class StateDispatcher extends Dispatcher {

	public StateDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
		this.tcpip.send(this.acceptorController.getValueState().ordinal());
	}

}
