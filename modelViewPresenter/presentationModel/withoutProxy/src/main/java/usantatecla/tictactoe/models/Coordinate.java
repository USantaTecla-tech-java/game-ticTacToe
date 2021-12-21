package usantatecla.tictactoe.models;

import usantatecla.utils.ConcreteCoordinate;
import usantatecla.utils.Direction;

import java.util.Random;

public class Coordinate extends ConcreteCoordinate {

    static final Coordinate NULL_COORDINATE = new Coordinate();
    public static final int DIMENSION = 3;

    public Coordinate() {
        super();
    }

    public Coordinate(int row, int column) {
        super(row, column);
    }

    @Override
    public boolean isNull() {
        return this == Coordinate.NULL_COORDINATE;
    }

    @Override
    public Direction getDirection(usantatecla.utils.Coordinate coordinate) {
        assert coordinate != null;

        if (coordinate.isNull()) {
            return Direction.NULL;
        }
        if (this.inInverseDiagonal() && ((Coordinate) coordinate).inInverseDiagonal()) {
            return Direction.INVERSE_DIAGONAL;
        }
        return super.getDirection(coordinate);
    }

    private boolean inInverseDiagonal() {
        if (this.isNull()) {
            return false;
        }
        return this.row + this.column == Coordinate.DIMENSION - 1;
    }

    public boolean isValid() {
        return this.row >= 0 && this.row < Coordinate.DIMENSION && this.column >= 0
                && this.column < Coordinate.DIMENSION;
    }

    public void random() {
        Random random = new Random(System.currentTimeMillis());
        this.row = random.nextInt(Coordinate.DIMENSION);
        this.column = random.nextInt(Coordinate.DIMENSION);
    }

}