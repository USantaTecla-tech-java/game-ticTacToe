package usantatecla.tictactoe.distributed.server.dispatchers;

import usantatecla.tictactoe.controllers.PlayController;

public class ValueTurnDispatcher extends Dispatcher {

    public ValueTurnDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
		this.tcpip.send(((PlayController) this.acceptorController).getValueFromTurn());
	}
    
}