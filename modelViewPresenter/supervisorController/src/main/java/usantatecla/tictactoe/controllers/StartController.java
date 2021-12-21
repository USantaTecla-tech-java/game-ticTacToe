package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.views.ViewFactory;

public class StartController extends Controller {

    public StartController(Game game, ViewFactory viewFactory) {
        super(game, viewFactory);
    }

    public void control() {
        this.viewFactory.createStartView().write();
        this.viewFactory.createBoardView(this.game.getBoard()).write();
    }

}
