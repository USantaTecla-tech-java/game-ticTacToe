package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.types.Coordinate;

public abstract class Controller {

    protected Game game;

    Controller(Game game) {
        this.game = game;
    }

    public Color getColor(Coordinate coordinate) {
        return this.game.getColor(coordinate);
    }

}
