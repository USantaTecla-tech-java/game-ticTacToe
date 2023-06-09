package usantatecla.tictactoe.views.console.menus;

import usantatecla.tictactoe.controllers.core.PlayController;
import usantatecla.tictactoe.views.console.models.MessageView;

class ExitCommand extends Command {

	protected ExitCommand(PlayController playController) {
		super(MessageView.EXIT_COMMAND.getMessage(), playController);
	}

	@Override
	protected void execute() {
		((PlayController) this.acceptorController).next();	
	}

	@Override
	protected boolean isActive() {
		return true;
	}

}
