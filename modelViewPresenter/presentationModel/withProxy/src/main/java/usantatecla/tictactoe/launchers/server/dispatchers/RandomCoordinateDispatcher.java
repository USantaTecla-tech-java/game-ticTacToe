package usantatecla.tictactoe.launchers.server.dispatchers;

import usantatecla.tictactoe.controllers.interfaces.PlayController;
import usantatecla.tictactoe.models.Coordinate;

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