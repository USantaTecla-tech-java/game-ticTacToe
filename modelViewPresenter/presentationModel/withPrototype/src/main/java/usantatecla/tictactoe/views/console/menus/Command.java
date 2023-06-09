package usantatecla.tictactoe.views.console.menus;

import usantatecla.tictactoe.controllers.core.AcceptorController;

abstract class Command extends usantatecla.utils.Command {

	protected AcceptorController acceptorController;

	protected Command(String title, AcceptorController acceptorController) {
		super(title);
		this.acceptorController = acceptorController;
	}
	
}
