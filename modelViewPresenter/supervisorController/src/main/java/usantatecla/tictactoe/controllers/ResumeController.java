package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.views.ViewFactory;

public class ResumeController extends Controller {

    public ResumeController(Game game, ViewFactory viewFactory) {
        super(game, viewFactory);
    }

    public boolean control() {
        boolean isResumed = this.viewFactory.createResumeView().read();
        if (isResumed) {
            this.game.reset();
        }
        return isResumed;
    }

}
