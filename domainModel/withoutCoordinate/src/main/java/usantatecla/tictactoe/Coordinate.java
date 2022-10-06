package usantatecla.tictactoe;

class Coordinate {

    public static final int DIMENSION = 3;

    Coordinate() {
        super();
    }

    Coordinate(int row, int column) {
        super(row, column);
    }

    @Override
    protected int getDimension() {
        return Coordinate.DIMENSION;
    }

    @Override
    protected String getErrorMessage() {
        return Error.WRONG_COORDINATES.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Coordinate other = (Coordinate) obj;
        if (!other.isNull()) {
            if (this.getRow() != other.getRow())
                return false;
          return this.getColumn() == other.getColumn();
        }
        return true;
    }

}
