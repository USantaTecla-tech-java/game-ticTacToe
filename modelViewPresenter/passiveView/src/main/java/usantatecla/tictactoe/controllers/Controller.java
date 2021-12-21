package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.types.Coordinate;
import usantatecla.tictactoe.views.ViewFactory;
import usantatecla.tictactoe.views.BoardView;

public abstract class Controller {

    protected Game game;
    protected ViewFactory viewFactory;

    Controller(Game game, ViewFactory viewFactory) {
        this.game = game;
        this.viewFactory = viewFactory;
    }

    void writeBoard() {
        BoardView boardView = this.viewFactory.createBoardView();
        for (int i = 0; i < Coordinate.DIMENSION; i++) {
            for (int j = 0; j < Coordinate.DIMENSION; j++) {
                boardView.set(this.game.getColor(new Coordinate(i, j)));
            }
        }
        boardView.write();
    }

}
