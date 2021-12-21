package usantatecla.tictactoe.views;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.types.Coordinate;
import usantatecla.tictactoe.types.Error;

abstract class PlayerView {

    protected Game game;

    void interact(Game game) {
        this.game = game;
        if (!this.game.areAllTokensOnBoard()) {
            this.putToken();
        } else {
            this.moveToken();
        }
    }

    private void putToken() {
        Coordinate coordinate;
        Error error;
        do {
            coordinate = this.getCoordinate(Message.ENTER_COORDINATE_TO_PUT);
            error = this.getPutTokenError(coordinate);
        } while (!error.isNull());
        this.game.putToken(coordinate);
    }

    protected abstract Coordinate getCoordinate(Message message);

    protected Error getPutTokenError(Coordinate coordinate) {
        return this.game.getPutTokenError(coordinate);
    }

    private void moveToken() {
        Coordinate origin;
        Error error;
        do {
            origin = this.getCoordinate(Message.COORDINATE_TO_REMOVE);
            error = this.getOriginMoveTokenError(origin);
        } while (error != Error.NULL);
        Coordinate target;
        do {
            target = this.getCoordinate(Message.COORDINATE_TO_MOVE);
            error = this.getTargetMoveTokenError(origin, target);
        } while (error != Error.NULL);
        this.game.moveToken(origin, target);
    }

    protected Error getOriginMoveTokenError(Coordinate origin) {
        return this.game.getOriginMoveTokenError(origin);
    }

    protected Error getTargetMoveTokenError(Coordinate origin, Coordinate target) {
        return this.game.getTargetMoveTokenError(origin, target);
    }
}
