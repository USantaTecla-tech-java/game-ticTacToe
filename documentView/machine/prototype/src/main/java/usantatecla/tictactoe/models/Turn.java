package usantatecla.tictactoe.models;

import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.types.Coordinate;
import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.types.PlayerType;

public class Turn {

    private Board board;
    public static final int NUMBER_PLAYERS = 2;
    private Player[] players;
    private int activePlayer;

    Turn(Board board) {
        assert board != null;
        this.board = board;
        this.players = new Player[Turn.NUMBER_PLAYERS];
        this.reset();
    }

    void reset() {
        this.activePlayer = 0;
    }

    void setUsers(int numberUsers) {
        for (int i = 0; i < Turn.NUMBER_PLAYERS; i++) {
            if (i < numberUsers) {
                this.players[i] = new UserPlayer(Color.get(i), this.board);
            } else {
                this.players[i] = new MachinePlayer(Color.get(i), this.board);
            }
        }
    }

    void next() {
        if (!this.board.isTicTacToe(this.getActiveColor())) {
            this.activePlayer = (this.activePlayer + 1) % Turn.NUMBER_PLAYERS;
        }
    }

    Player getActivePlayer() {
        return this.players[this.activePlayer];
    }

    Color getActiveColor() {
        return this.getActivePlayer().getColor();
    }

    boolean areAllTokensOnBoard() {
        return this.getActivePlayer().areAllTokensOnBoard();
    }

    void putToken(Coordinate coordinate) {
        this.getActivePlayer().putToken(coordinate);
    }

    Error getPutTokenError(Coordinate coordinate) {
        return this.getActivePlayer().getPutTokenError(coordinate);
    }

    void moveToken(Coordinate origin, Coordinate target) {
        this.getActivePlayer().moveToken(origin, target);
    }

    Error getOriginMoveTokenError(Coordinate coordinate) {
        return this.getActivePlayer().getOriginMoveTokenError(coordinate);
    }

    Error getTargetMoveTokenError(Coordinate origin, Coordinate target) {
        return this.getActivePlayer().getTargetMoveTokenError(origin, target);
    }

    PlayerType getType() {
        return this.getActivePlayer().getType();
    }

    Coordinate getRandomCoordinate() {
        return ((MachinePlayer) this.getActivePlayer()).getRandomCoordinate();
    }

}
