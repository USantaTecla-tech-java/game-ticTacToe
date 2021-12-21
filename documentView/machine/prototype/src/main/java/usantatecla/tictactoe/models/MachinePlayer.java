package usantatecla.tictactoe.models;

import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.types.Coordinate;
import usantatecla.tictactoe.types.PlayerType;

class MachinePlayer extends Player {

	MachinePlayer(Color color, Board board) {
		super(color, board);
		this.type = PlayerType.MACHINE;
	}

	Coordinate getRandomCoordinate(){
		Coordinate coordinate = new Coordinate();
		coordinate.random();
		return coordinate;
	}

}
