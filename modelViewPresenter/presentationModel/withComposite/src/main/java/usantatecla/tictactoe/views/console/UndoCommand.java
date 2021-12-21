package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.views.Message;

class UndoCommand extends Command {

	UndoCommand(PlayController playController) {
		super(Message.UNDO_COMMAND.toString(), playController);
	}

	@Override
	public void execute() {
		this.playController.undo();
		super.execute();
	}

	@Override
	public boolean isActive() {
		return this.playController.undoable();
	}
	
}
