package usantatecla.tictactoe.daos.core;

import usantatecla.tictactoe.models.core.Board;
import usantatecla.tictactoe.models.core.Coordinate;

public class BoardDAO {

    protected Board board;

    public BoardDAO(Board board) {
	    this.board = board;
    }
    
    public void loadCoordinateInBoard(String tokenCoordinate, int playerIndex, int coordinateIndex) {
        if ("-".equals(tokenCoordinate)) {
            this.board.setCoordinate(playerIndex, coordinateIndex, null);
        } else {
            String[] coordinatesString = tokenCoordinate.split("\\.");
            this.board.setCoordinate(playerIndex, coordinateIndex, new Coordinate(Integer.parseInt(coordinatesString[0]),
            Integer.parseInt(coordinatesString[1])));
        }
    }
    
}