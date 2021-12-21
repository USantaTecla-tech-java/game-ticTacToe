package usantatecla.tictactoe.views;

import usantatecla.tictactoe.types.Coordinate;
import usantatecla.tictactoe.types.Error;

class UserPlayerView extends PlayerView {

    @Override
    protected Coordinate getCoordinate(Message message) {
        assert message != null;

        return (Coordinate) new CoordinateView().read(message.toString());
    }

    @Override
    protected Error getPutTokenError(Coordinate coordinate) {
        assert coordinate != null;

        Error error = super.getPutTokenError(coordinate);
        new ErrorView().writeln(error);
        return error;
    }

    @Override
    protected Error getOriginMoveTokenError(Coordinate coordinate) {
        assert !coordinate.isNull();

        Error error = super.getOriginMoveTokenError(coordinate);
        new ErrorView().writeln(error);
        return error;
    }

    @Override
    protected Error getTargetMoveTokenError(Coordinate origin, Coordinate target) {
        assert !origin.isNull() && !target.isNull();

        Error error = super.getTargetMoveTokenError(origin, target);
        new ErrorView().writeln(error);
        return error;
    }


}
