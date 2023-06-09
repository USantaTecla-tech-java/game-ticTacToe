package usantatecla.tictactoe.launchers.server.dispatchers.undoredo;

import usantatecla.tictactoe.controllers.core.PlayController;
import usantatecla.tictactoe.launchers.server.dispatchers.Dispatcher;

public class UndoableDispatcher extends Dispatcher {

	public UndoableDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
		this.tcpip.send(((PlayController)this.acceptorController).undoable());
	}

}
