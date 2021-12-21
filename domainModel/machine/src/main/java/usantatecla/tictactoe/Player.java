package usantatecla.tictactoe;

abstract class Player {

    protected Color color;
    protected Board board;
    private int putTokens;

    Player(Color color, Board board) {
        assert !color.isNull();
        assert board != null;

        this.color = color;
        this.board = board;
        this.putTokens = 0;
    }

    void play() {
        if (this.putTokens < Coordinate.DIMENSION) {
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
        this.board.putToken(coordinate, this.color);
        this.putTokens++;
    }

    protected abstract Coordinate getCoordinate(Message message);

    protected Error getPutTokenError(Coordinate coordinate) {
        if (!this.board.isEmpty(coordinate)) {
            return Error.NOT_EMPTY;
        }
        return Error.NULL;
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
        this.board.moveToken(origin, target);
    }

    protected Error getOriginMoveTokenError(Coordinate origin) {
        if (!this.board.isOccupied(origin, this.color)) {
            return Error.NOT_OWNER;
        }
        return Error.NULL;
    }

    protected Error getTargetMoveTokenError(Coordinate origin, Coordinate target) {
        if (origin.equals(target)) {
            return Error.SAME_COORDINATES;
        }
        if (!this.board.isEmpty(target)) {
            return Error.NOT_EMPTY;
        }
        return Error.NULL;
    }

    void writeWinner() {
        Message.PLAYER_WIN.writeln(this.color.name());
    }

    Color getColor() {
        return this.color;
    }

}
