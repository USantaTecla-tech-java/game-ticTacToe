package usantatecla.tictactoe.models;

import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.types.Coordinate;
import usantatecla.tictactoe.types.Error;

public class Session {

    private State state;
    private Game game;
    private Registry registry;

    public Session() {
        this.state = new State();
        this.game = new Game();
        this.registry = new Registry(game);
    }

    public void reset() {
        this.game.reset();
        this.state.reset();
        this.registry.reset();
    }

    public void nextState() {
        this.state.next();
    }

    public StateValue getValueState() {
        return this.state.getValueState();
    }

    public boolean undoable() {
        return this.registry.undoable();
    }

    public boolean redoable() {
        return this.registry.redoable();
    }

    public void undo() {
        this.registry.undo();
    }

    public void redo() {
        this.registry.redo();
    }

    public void next() {
        this.game.next();
        this.registry.register();
    }

    public Color getColor(Coordinate coordinate) {
        return this.game.getColor(coordinate);
    }

    public boolean areAllTokensOnBoard() {
        return this.game.areAllTokensOnBoard();
    }

    public boolean isTicTacToe() {
        return this.game.isTicTacToe();
    }

    public Color getActiveColor() {
        return this.game.getActiveColor();
    }

    public Error getPutTokenError(Coordinate coordinate) {
        return this.game.getPutTokenError(coordinate);
    }

    public void putToken(Coordinate coordinate) {
        this.game.putToken(coordinate);
    }

    public void moveToken(Coordinate origin, Coordinate target) {
        this.game.moveToken(origin,target);
    }

    public Error getTargetMoveTokenError(Coordinate origin, Coordinate target) {
        return this.game.getTargetMoveTokenError(origin, target);
    }

    public Error getOriginMoveTokenError(Coordinate coordinate) {
        return this.game.getOriginMoveTokenError(coordinate);
    }

}
