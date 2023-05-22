package usantatecla.tictactoe.distributed.server.dispatchers;

import usantatecla.tictactoe.controllers.interfaces.PlayController;

public class TicTacToeDispatcher extends Dispatcher {

    public TicTacToeDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
		this.tcpip.send(((PlayController)this.acceptorController).isTicTacToe());
	}
    
}