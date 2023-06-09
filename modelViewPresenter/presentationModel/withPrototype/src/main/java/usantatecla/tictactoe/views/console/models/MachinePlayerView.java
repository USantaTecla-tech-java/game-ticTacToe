package usantatecla.tictactoe.views.console.models;

import usantatecla.tictactoe.controllers.core.PlayController;
import usantatecla.tictactoe.models.core.Coordinate;
import usantatecla.tictactoe.models.types.Error;

public class MachinePlayerView extends PlayerView {

	public MachinePlayerView(PlayController playController) {
		super(playController);
	}

	@Override
	public Coordinate readCoordinateToPut() {
		Coordinate coordinate;
		Error error;
		do {
			coordinate = this.playController.generateRandomCoordinate();
			error = this.getPutCoordinateError(coordinate);
		} while (error != null);
		return coordinate;
	}

	@Override
	public Coordinate[] readCoordinatesToMove() {
		Coordinate[] coordinates = new Coordinate[2];
		Error error;
		do {
			coordinates[0] = this.playController.generateRandomCoordinate();
			error = this.getMoveOriginCoordinateError(coordinates[0]);
		} while (error != null);
		do {
			coordinates[1] = this.playController.generateRandomCoordinate();
			error = this.getMoveTargetCoordinateError(coordinates[0], coordinates[1]);
		} while (error != null);
		return coordinates;
	}

}