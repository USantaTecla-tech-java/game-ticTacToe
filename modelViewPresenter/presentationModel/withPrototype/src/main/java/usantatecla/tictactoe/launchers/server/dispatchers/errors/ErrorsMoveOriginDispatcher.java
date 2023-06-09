package usantatecla.tictactoe.launchers.server.dispatchers.errors;

import usantatecla.tictactoe.controllers.core.PlayController;
import usantatecla.tictactoe.launchers.server.dispatchers.core.Dispatcher;
import usantatecla.tictactoe.models.core.Coordinate;

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