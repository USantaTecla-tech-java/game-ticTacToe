package usantatecla.tictactoe.launchers.server.dispatchers;

import usantatecla.tictactoe.controllers.core.PlayController;
import usantatecla.tictactoe.launchers.server.dispatchers.core.Dispatcher;
import usantatecla.tictactoe.models.core.Coordinate;

public class MoveTokenDispatcher extends Dispatcher {

	public MoveTokenDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
		int originRow = this.tcpip.receiveInt();
		int originColumn = this.tcpip.receiveInt();
		int targetRow = this.tcpip.receiveInt();
		int targetColumn = this.tcpip.receiveInt();
		Coordinate[] coordinates = new Coordinate[2];
		coordinates[0] = new Coordinate(originRow, originColumn);
		coordinates[1] = new Coordinate(targetRow, targetColumn);
		((PlayController) this.acceptorController).moveTokenPlayerFromTurn(coordinates);
	}
}