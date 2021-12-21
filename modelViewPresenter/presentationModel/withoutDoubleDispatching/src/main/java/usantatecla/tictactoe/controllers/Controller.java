package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.models.State;
import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.types.Coordinate;

public abstract class Controller {

    protected Game game;
    protected State state;

    Controller(Game game, State state) {
        this.game = game;
        this.state = state;
    }

    public void nextState() {
        this.state.next();
    }

    public Color getColor(Coordinate coordinate) {
        return this.game.getColor(coordinate);
    }

}
