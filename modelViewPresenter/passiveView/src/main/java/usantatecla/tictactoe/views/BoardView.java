package usantatecla.tictactoe.views;

import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.types.Coordinate;

import java.util.ArrayList;
import java.util.List;

public abstract class BoardView {

    protected List<Color> colors;

    public BoardView() {
        this.colors = new ArrayList<>();
    }

    public void set(Color color) {
        assert this.colors.size() < Coordinate.DIMENSION * Coordinate.DIMENSION;

        this.colors.add(color);
    }

    public abstract void write();

}
