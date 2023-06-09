package usantatecla.tictactoe.launchers.server.dispatchers.errors;

import usantatecla.tictactoe.controllers.core.PlayController;
import usantatecla.tictactoe.launchers.server.dispatchers.Dispatcher;
import usantatecla.tictactoe.models.Coordinate;

public class ErrorsMoveTargetDispatcher extends Dispatcher {

	public ErrorsMoveTargetDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
		int originRow = this.tcpip.receiveInt();
		int originColumn = this.tcpip.receiveInt();
		int targetRow = this.tcpip.receiveInt();
		int targetColumn = this.tcpip.receiveInt();
		this.tcpip.send(((PlayController) this.acceptorController).getMoveTargetCoordinateError(
				new Coordinate(originRow, originColumn), new Coordinate(targetRow, targetColumn)));
	}
}