package usantatecla.tictactoe.launchers.server.dispatchers;

import usantatecla.tictactoe.controllers.core.StartController;

public class CreatePlayersDispatcher extends Dispatcher {

    public CreatePlayersDispatcher(StartController startController) {
		super(startController);
	}

	@Override
	public void dispatch() {
        int numberOfUsers = this.tcpip.receiveInt();
		((StartController)this.acceptorController).createPlayers(numberOfUsers);
	}
    
}