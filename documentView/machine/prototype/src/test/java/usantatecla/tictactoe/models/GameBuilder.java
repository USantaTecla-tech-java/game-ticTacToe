package usantatecla.tictactoe.models;

import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.types.Coordinate;

import java.util.List;

public class GameBuilder {

    private String[] rows;
    private Color color;
    private int numberUsers;
    private Game game;

    public GameBuilder() {
        this.rows = new String[]{
            "   ",
            "   ",
            "   "};
        this.numberUsers = 0;
    }

    public GameBuilder rows(String... rows) {
        this.rows = rows;
        return this;
    }

    public GameBuilder turn(Color color) {
        this.color = color;
        return this;
    }

    public GameBuilder users(int numberUsers) {
        this.numberUsers = numberUsers;
        return this;
    }

    public Game build() {
        this.game = new Game();
        this.game.setUsers(this.numberUsers);
        this.buildBoard();
        if (this.color != null && this.game.getActiveColor() != this.color) {
            this.game.next();
        }
        return this.game;
    }

    private void buildBoard() {
        Board board = new BoardBuilder().rows(this.rows).build();
        this.putTokens(board, Color.X);
        this.game.next();
        this.putTokens(board, Color.O);
    }

    private void putTokens(Board board, Color color) {
        List<Coordinate> coordinates = board.getCoordinates(color);
        while (coordinates.size() > 0) {
            Coordinate coordinate = coordinates.remove(0);
            this.game.putToken(coordinate);
        }
    }
    
}
