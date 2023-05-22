package usantatecla.tictactoe.distributed.server.dispatchers;

import usantatecla.tictactoe.controllers.interfaces.PlayController;
import usantatecla.tictactoe.models.Coordinate;

public class TokenCharDispatcher extends Dispatcher {
    
    public TokenCharDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
        int row = this.tcpip.receiveInt();
        int column = this.tcpip.receiveInt();
		this.tcpip.send(((PlayController)this.acceptorController).getTokenChar(new Coordinate(row, column)));
    }
    
}