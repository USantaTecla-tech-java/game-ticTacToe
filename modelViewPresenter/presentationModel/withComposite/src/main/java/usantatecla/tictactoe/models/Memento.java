package usantatecla.tictactoe.models;

import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.types.Coordinate;

class Memento {

    private int activePlayer;
    private char[] boardColors;

    Memento(Board board, Turn turn) {
        this.boardColors = board.toCharacterArray();
        this.activePlayer = turn.getActiveColor().ordinal();
    }

    Board getBoard() {
        Board board = new Board();
        int colorsCount = 0;
        for (int i = 0; i < Coordinate.DIMENSION; i++) {
            for (int j = 0; j < Coordinate.DIMENSION; j++) {
                board.putToken(new Coordinate(i, j), Color.get(this.boardColors[colorsCount++]));
            }
        }
        return board;
    }

    int getActivePlayer() {
        return this.activePlayer;
    }

    int getPlayerPutTokens(Color color) {
        int playerPutTokens = 0;
        for (int i = 0; i < this.boardColors.length; i++) {
            if (Color.get(this.boardColors[i]) == color) {
                playerPutTokens++;
            }
        }
        return playerPutTokens;
    }

}
