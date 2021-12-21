package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.views.Message;

class ActionCommand extends Command {

	ActionCommand(PlayController playController) {
		super(Message.ACTION_COMMAND.toString(), playController);
	}

	@Override
	public void execute() {
		new PlayerView(this.playController).interact();
    this.playController.next();
		super.execute();
	}

	@Override
	public boolean isActive() {
		return true;
	}

}
