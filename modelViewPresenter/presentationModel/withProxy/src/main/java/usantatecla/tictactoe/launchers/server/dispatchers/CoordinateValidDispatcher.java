package usantatecla.tictactoe.launchers.server.dispatchers;

import usantatecla.tictactoe.controllers.core.PlayController;
import usantatecla.tictactoe.models.Coordinate;

public class CoordinateValidDispatcher extends Dispatcher {

	public CoordinateValidDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
		int row = this.tcpip.receiveInt();
		int column = this.tcpip.receiveInt();
		this.tcpip.send(((PlayController) this.acceptorController).isCoordinateValid(new Coordinate(row, column)));
	}

}