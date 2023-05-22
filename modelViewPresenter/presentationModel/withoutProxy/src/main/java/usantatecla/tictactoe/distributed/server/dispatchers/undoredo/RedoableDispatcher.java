package usantatecla.tictactoe.distributed.server.dispatchers.undoredo;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.distributed.server.dispatchers.Dispatcher;

public class RedoableDispatcher extends Dispatcher {

	public RedoableDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
		this.tcpip.send(((PlayController)this.acceptorController).redoable());
	}

}
