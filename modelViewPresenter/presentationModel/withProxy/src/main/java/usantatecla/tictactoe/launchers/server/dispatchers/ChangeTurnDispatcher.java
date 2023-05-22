package usantatecla.tictactoe.launchers.server.dispatchers;

import usantatecla.tictactoe.controllers.interfaces.PlayController;

public class ChangeTurnDispatcher extends Dispatcher {

    public ChangeTurnDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
		((PlayController)this.acceptorController).changeTurn();
	}
    
}