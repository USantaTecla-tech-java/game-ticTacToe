package usantatecla.tictactoe;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.controllers.ResumeController;
import usantatecla.tictactoe.controllers.StartController;
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
        do {
            if (logic.getController() instanceof StartController) {
                this.view.start((StartController) logic.getController());
            } else {
                if (logic.getController() instanceof PlayController) {
                    this.view.play((PlayController) logic.getController());
                } else {
                    this.view.resume((ResumeController) logic.getController());
                }
            }
        } while (logic.getController() != null);
    }

}
