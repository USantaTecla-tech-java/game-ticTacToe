package usantatecla.tictactoe.launchers.server.dispatchers;

import usantatecla.tictactoe.controllers.core.PlayController;

public class ChangeTurnDispatcher extends Dispatcher {

    public ChangeTurnDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
		((PlayController)this.acceptorController).changeTurn();
	}
    
}