package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.types.Coordinate;
import usantatecla.tictactoe.types.Error;

public class Logic {

    private Game game;
    private StartController startController;
    private PlayController playController;
    private ResumeController resumeController;

    public Logic(Game game) {
        this.game = game;
        this.startController = new StartController(this.game);
        this.playController = new PlayController(this.game);
        this.resumeController = new ResumeController(this.game);
    }

    public Color getColor(Coordinate coordinate) {
        return this.startController.getColor(coordinate);
    }

    public boolean areAllTokensOnBoard() {
        return this.playController.areAllTokensOnBoard();
    }

    public boolean isTicTacToe() {
        return this.playController.isTicTacToe();
    }

    public void next() {
        this.playController.next();
    }

    public Color getActiveColor() {
        return this.playController.getActiveColor();
    }

    public void putToken(Coordinate coordinate) {
        this.playController.putToken(new Coordinate(coordinate.getRow(), coordinate.getColumn()));
    }

    public Error getPutTokenError(Coordinate coordinate) {
        return this.playController.getPutTokenError(coordinate);
    }

    public void moveToken(Coordinate origin, Coordinate target) {
        this.playController.moveToken(
                new Coordinate(origin.getRow(), origin.getColumn()),
                new Coordinate(target.getRow(), target.getColumn())
        );
    }

    public Error getOriginMoveTokenError(Coordinate coordinate) {
        return this.playController.getOriginMoveTokenError(coordinate);
    }

    public Error getTargetMoveTokenError(Coordinate origin, Coordinate target) {
        return this.playController.getTargetMoveTokenError(origin, target);
    }

    public void reset() {
        this.resumeController.reset();
    }

}
