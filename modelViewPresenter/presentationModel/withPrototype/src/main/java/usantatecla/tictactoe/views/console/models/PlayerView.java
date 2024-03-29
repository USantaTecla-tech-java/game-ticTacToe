package usantatecla.tictactoe.views.console.models;

import usantatecla.tictactoe.controllers.core.PlayController;
import usantatecla.tictactoe.models.core.Coordinate;
import usantatecla.tictactoe.models.types.Error;

public abstract class PlayerView {

    protected PlayController playController;

    public PlayerView(PlayController playController) {
        this.playController = playController;
    }
  
    public abstract Coordinate readCoordinateToPut();
    public abstract Coordinate[] readCoordinatesToMove();

    public Error getPutCoordinateError(Coordinate coordinate) {
        return this.playController.getPutCoordinateError(coordinate);
	}

	public Error getMoveOriginCoordinateError(Coordinate originCoordinate) {
		return this.playController.getMoveOriginCoordinateError(originCoordinate);
	}

	public Error getMoveTargetCoordinateError(Coordinate originCoordinate, Coordinate targetCoordinate) {
		return this.playController.getMoveTargetCoordinateError(originCoordinate, targetCoordinate);
	}
}