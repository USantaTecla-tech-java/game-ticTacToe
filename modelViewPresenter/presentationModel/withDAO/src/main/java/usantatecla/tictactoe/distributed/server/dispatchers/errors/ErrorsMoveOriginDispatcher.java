package usantatecla.tictactoe.distributed.server.dispatchers.errors;

import usantatecla.tictactoe.controllers.interfaces.PlayController;
import usantatecla.tictactoe.distributed.server.dispatchers.Dispatcher;
import usantatecla.tictactoe.models.Coordinate;

public class ErrorsMoveOriginDispatcher extends Dispatcher {

	public ErrorsMoveOriginDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
		int row = this.tcpip.receiveInt();
		int column = this.tcpip.receiveInt();
		this.tcpip.send(
				((PlayController) this.acceptorController).getMoveOriginCoordinateError(new Coordinate(row, column)));
	}
}