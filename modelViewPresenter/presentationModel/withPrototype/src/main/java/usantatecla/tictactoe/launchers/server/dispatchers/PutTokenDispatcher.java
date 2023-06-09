package usantatecla.tictactoe.launchers.server.dispatchers;

import usantatecla.tictactoe.controllers.core.PlayController;
import usantatecla.tictactoe.launchers.server.dispatchers.core.Dispatcher;
import usantatecla.tictactoe.models.core.Coordinate;

public class PutTokenDispatcher extends Dispatcher {
    
    public PutTokenDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
        int row = this.tcpip.receiveInt();
        int column = this.tcpip.receiveInt();
		((PlayController)this.acceptorController).putTokenPlayerFromTurn(new Coordinate(row, column));
	}
}