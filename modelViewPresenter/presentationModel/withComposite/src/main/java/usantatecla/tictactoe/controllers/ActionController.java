package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Session;
import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.types.Coordinate;
import usantatecla.tictactoe.types.Error;

class ActionController extends Controller  {

    public ActionController(Session session) {
        super(session);
    }

    public boolean areAllTokensOnBoard() {
        return this.session.areAllTokensOnBoard();
    }

    public boolean isTicTacToe() {
        return this.session.isTicTacToe();
    }

    public void next() {
        this.session.next();
    }

    public Color getActiveColor() {
        return this.session.getActiveColor();
    }

    public void putToken(Coordinate coordinate) {
        this.session.putToken(new Coordinate(coordinate.getRow(), coordinate.getColumn()));
    }

    public Error getPutTokenError(Coordinate coordinate) {
        return this.session.getPutTokenError(coordinate);
    }

    public void moveToken(Coordinate origin, Coordinate target) {
        this.session.moveToken(
                new Coordinate(origin.getRow(), origin.getColumn()),
                new Coordinate(target.getRow(), target.getColumn())
        );
    }

    public Error getOriginMoveTokenError(Coordinate coordinate) {
        return this.session.getOriginMoveTokenError(coordinate);
    }

    public Error getTargetMoveTokenError(Coordinate origin, Coordinate target) {
        return this.session.getTargetMoveTokenError(origin, target);
    }
    
}
