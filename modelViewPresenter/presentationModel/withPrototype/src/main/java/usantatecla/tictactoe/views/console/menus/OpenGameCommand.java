package usantatecla.tictactoe.views.console.menus;

import usantatecla.tictactoe.controllers.core.StartController;
import usantatecla.tictactoe.views.console.models.MessageView;

class OpenGameCommand extends Command{

	protected OpenGameCommand(StartController startController) {
		super(MessageView.OPENGAME_COMMAND.getMessage(), startController);
	}

	@Override
	protected void execute() {
		new GameSelectMenu((StartController) this.acceptorController).execute();
	}

	@Override
	protected boolean isActive() {
		return true;
	}

}
