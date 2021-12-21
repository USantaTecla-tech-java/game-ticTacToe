package usantatecla.tictactoe.models;

import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.types.Coordinate;

import java.util.List;

public class SessionBuilder {
    
    private String[] rows;
    private Color color;
    private Session session;
    private StateValue stateValue;

    public SessionBuilder() {
        this.rows = new String[]{
            "   ",
            "   ",
            "   "};
    }

    public SessionBuilder rows(String... rows) {
        this.rows = rows;
        return this;
    }

    public SessionBuilder turn(Color color) {
        this.color = color;
        return this;
    }

    public SessionBuilder state(StateValue stateValue) {
        this.stateValue = stateValue;
        return this;
    }

    public Session build() {
        this.session = new Session();
        this.buildBoard();
        if(this.stateValue != null) {
            while (this.stateValue != this.session.getValueState()) {
                this.session.nextState();
            }
        }
        if (this.color != null && this.session.getActiveColor() != this.color) {
            this.session.next();
        }
        return this.session;
    }

    private void buildBoard() {
        Board board = new BoardBuilder().rows(this.rows).build();
        this.putTokens(board, Color.X);
        this.session.next();
        this.putTokens(board, Color.O);
    }

    private void putTokens(Board board, Color color) {
        List<Coordinate> coordinates = board.getCoordinates(color);
        while (coordinates.size() > 0) {
            Coordinate coordinate = coordinates.remove(0);
            this.session.putToken(coordinate);
        }
    }

}
