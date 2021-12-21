package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.views.Message;

class RedoCommand extends Command {
	
	RedoCommand(PlayController playController) {
		super(Message.REDO_COMMAND.toString(), playController);
	}

	@Override
	public void execute() {
		this.playController.redo();
		super.execute();
	}

	@Override
	public boolean isActive() {
		return this.playController.redoable();
	}

}
