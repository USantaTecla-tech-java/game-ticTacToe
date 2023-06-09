package usantatecla.tictactoe.launchers.core;

import usantatecla.tictactoe.controllers.core.AcceptorController;
import usantatecla.tictactoe.controllers.core.Logic;
import usantatecla.tictactoe.views.console.core.View;

public abstract class TicTacToe {

    protected Logic logic;

    private View view;

    protected TicTacToe() {
		this.view = new View();
	}

    protected void play() {
		AcceptorController acceptorController;
		do {
			acceptorController = this.logic.getController();
			if (acceptorController != null){
				this.view.interact(acceptorController);
			}
		} while (acceptorController != null);
	}
}