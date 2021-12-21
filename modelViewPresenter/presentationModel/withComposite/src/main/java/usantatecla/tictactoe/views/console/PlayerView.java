package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.types.Coordinate;
import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.views.Message;

class PlayerView {

    private PlayController playController;

    PlayerView(PlayController playController) {
        this.playController = playController;
    }

    void interact() {
        if (!this.playController.areAllTokensOnBoard()) {
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
        this.playController.putToken(coordinate);
    }

    Coordinate getCoordinate(Message message) {
        assert message != null;

        return (Coordinate) new CoordinateView().read(message.toString());
    }

    private Error getPutTokenError(Coordinate coordinate) {
        assert coordinate != null;

        Error error = this.playController.getPutTokenError(coordinate);
        new ErrorView().writeln(error);
        return error;
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
        this.playController.moveToken(origin, target);
    }

    private Error getOriginMoveTokenError(Coordinate origin) {
        assert !origin.isNull();

        Error error = this.playController.getOriginMoveTokenError(origin);
        new ErrorView().writeln(error);
        return error;
    }

    private Error getTargetMoveTokenError(Coordinate origin, Coordinate target) {
        assert !origin.isNull() && !target.isNull();

        Error error = this.playController.getTargetMoveTokenError(origin, target);
        new ErrorView().writeln(error);
        return error;
    }
    
}
