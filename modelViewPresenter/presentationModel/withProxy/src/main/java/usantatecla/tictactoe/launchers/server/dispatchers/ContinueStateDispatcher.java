package usantatecla.tictactoe.launchers.server.dispatchers;

import usantatecla.tictactoe.controllers.interfaces.PlayController;

public class ContinueStateDispatcher extends Dispatcher {

    public ContinueStateDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
		((PlayController)this.acceptorController).continueState();
	}
    
}