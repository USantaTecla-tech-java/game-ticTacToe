package usantatecla.tictactoe.launchers.server.dispatchers;

import usantatecla.tictactoe.controllers.core.PlayController;
import usantatecla.tictactoe.launchers.server.dispatchers.core.Dispatcher;
import usantatecla.tictactoe.models.core.Coordinate;

public class RandomCoordinateDispatcher extends Dispatcher {

    public RandomCoordinateDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
        Coordinate coordinate = ((PlayController)this.acceptorController).generateRandomCoordinate();
        this.tcpip.send(coordinate.getRow());
        this.tcpip.send(coordinate.getColumn());
	}
    
}