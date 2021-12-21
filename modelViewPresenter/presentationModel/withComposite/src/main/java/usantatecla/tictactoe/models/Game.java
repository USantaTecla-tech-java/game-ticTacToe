package usantatecla.tictactoe.models;

import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.types.Coordinate;
import usantatecla.tictactoe.types.Error;

class Game {

    private Board board;
    private Turn turn;

    Game() {
        this.board = new Board();
        this.turn = new Turn(this.board);
    }

    void reset() {
        this.board.reset();
        this.turn.reset();
    }

    Memento createMemento() {
        return new Memento(this.board, this.turn);
    }

    void setMemento(Memento memento) {
        this.board = memento.getBoard();
        this.turn = new Turn(this.board);
        this.turn.setActivePlayer(memento.getActivePlayer());
        for (Color color : Color.getAll()) {
            this.turn.setPlayerPutTokens(color, memento.getPlayerPutTokens(color));
        }
    }

    void next() {
        this.turn.next();
    }

    Color getActiveColor() {
        return this.turn.getActiveColor();
    }

    boolean isTicTacToe() {
        return this.board.isTicTacToe(this.turn.getActiveColor());
    }

    Color getColor(Coordinate coordinate) {
        return this.board.getColor(coordinate);
    }

    boolean areAllTokensOnBoard() {
        return this.turn.areAllTokensOnBoard();
    }

    void putToken(Coordinate coordinate) {
        this.turn.putToken(coordinate);
    }

    Error getPutTokenError(Coordinate coordinate) {
        return this.turn.getPutTokenError(coordinate);
    }

    void moveToken(Coordinate origin, Coordinate target) {
        this.turn.moveToken(origin, target);
    }

    Error getOriginMoveTokenError(Coordinate coordinate) {
        return this.turn.getOriginMoveTokenError(coordinate);
    }

    Error getTargetMoveTokenError(Coordinate origin, Coordinate target) {
        return this.turn.getTargetMoveTokenError(origin, target);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Game other = (Game) obj;
        if (board == null) {
            if (other.board != null)
                return false;
        } else if (!board.equals(other.board))
            return false;
        if (turn == null) {
            return other.turn == null;
        } else return turn.equals(other.turn);
    }

}
