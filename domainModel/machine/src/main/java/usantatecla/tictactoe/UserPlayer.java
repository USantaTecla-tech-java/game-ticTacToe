package usantatecla.tictactoe;

class UserPlayer extends Player {

    UserPlayer(Color color, Board board) {
        super(color, board);
    }

    protected Coordinate getCoordinate(Message message) {
        assert message != null;

        Coordinate coordinate = new Coordinate();
        coordinate.read(message.toString());
        return coordinate;
    }

    @Override
    protected Error getPutTokenError(Coordinate coordinate) {
        assert coordinate != null;

        Error error = super.getPutTokenError(coordinate);
        error.writeln();
        return error;
    }

    @Override
    protected Error getOriginMoveTokenError(Coordinate coordinate) {
        assert !coordinate.isNull();

        Error error = super.getOriginMoveTokenError(coordinate);
        error.writeln();
        return error;
    }

    @Override
    protected Error getTargetMoveTokenError(Coordinate origin, Coordinate target) {
        assert !origin.isNull() && !target.isNull();

        Error error = super.getTargetMoveTokenError(origin, target);
        error.writeln();
        return error;
    }

}
