package usantatecla.tictactoe;

import usantatecla.tictactoe.controllers.AcceptorController;
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
        AcceptorController acceptorController;
        do {
            acceptorController = logic.getController();
            if (acceptorController != null)
                acceptorController.accept(this.view);
        } while (acceptorController != null);
    }

}
