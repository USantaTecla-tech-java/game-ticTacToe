package usantatecla.tictactoe;

import usantatecla.tictactoe.controllers.Controller;
import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.views.View;

abstract class TicTacToe {

    private View view;
    private Logic logic;

    protected TicTacToe() {
        this.logic = new Logic();
        this.view = this.createView();
    }

    protected abstract View createView();

    protected void play() {
        Controller controller;
        do {
            controller = logic.getController();
            if (controller != null)
                controller.accept(this.view);
        } while (controller != null);
    }

}
