package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.types.Coordinate;

public class StartController extends Controller {

    public StartController(Game game) {
        super(game);
    }

    public Color getColor(Coordinate coordinate) {
        return this.game.getColor(coordinate);
    }

}
