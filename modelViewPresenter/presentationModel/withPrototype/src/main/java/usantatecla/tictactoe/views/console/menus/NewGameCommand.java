package usantatecla.tictactoe.views.console.menus;

import usantatecla.tictactoe.controllers.core.StartController;
import usantatecla.tictactoe.models.core.Turn;
import usantatecla.tictactoe.views.console.models.MessageView;
import usantatecla.utils.PlayersDialog;

class NewGameCommand extends Command {

	protected NewGameCommand(StartController startController) {
		super(MessageView.NEWGAME_COMMAND.getMessage(), startController);
	}

	@Override
	protected void execute() {
		((StartController) this.acceptorController).start();
		int numberOfUsers = new PlayersDialog().read(Turn.NUM_PLAYERS);
		((StartController) this.acceptorController).createPlayers(numberOfUsers);
	}

	@Override
	protected boolean isActive() {
		return true;
	}

}
