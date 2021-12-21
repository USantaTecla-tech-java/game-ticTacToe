package usantatecla.tictactoe;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.views.View;

abstract class TicTacToe {

    private View view;
    private Logic logic;

    protected TicTacToe() {
        this.logic = new Logic(new Game());
        this.view = this.createView(this.logic);
    }

    protected abstract View createView(Logic logic);

    protected void play() {
        do {
            this.view.start();
            this.view.play();
        } while (this.view.resume());
    }

}
