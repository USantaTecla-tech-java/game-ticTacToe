package usantatecla.tictactoe.launchers.server.dispatchers.undoredo;

import usantatecla.tictactoe.controllers.core.PlayController;
import usantatecla.tictactoe.launchers.server.dispatchers.Dispatcher;

public class RedoDispatcher extends Dispatcher {

	public RedoDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
		((PlayController)this.acceptorController).redo();
	}

}
