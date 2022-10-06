package usantatecla.tictactoe;

import usantatecla.utils.SquareBoundedCoordinate;
import usantatecla.utils.SquareBoundedCoordinateTest;

public class CoordinateTest extends SquareBoundedCoordinateTest {

    @Override
    public SquareBoundedCoordinate getNullCoordinate() {
        return new Coordinate();
    }

    @Override
    public int getDimension() {
        return Coordinate.DIMENSION;
    }

    @Override
    public SquareBoundedCoordinate getCoordinate(int row, int column) {
        return new Coordinate(row, column);
    }


}
