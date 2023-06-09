package usantatecla.tictactoe.views.console.menus;

import usantatecla.tictactoe.controllers.core.PlayController;
import usantatecla.tictactoe.views.console.models.GameView;
import usantatecla.tictactoe.views.console.models.MessageView;

class UndoCommand extends Command {

	private PlayController playController;

	UndoCommand(PlayController playController) {
		super(MessageView.UNDO_COMMAND.getMessage(), playController);
		this.playController = (PlayController) this.acceptorController;
	}

	
	protected void execute() {
		(this.playController).undo();
		new GameView((this.playController));
	}

	
	protected boolean isActive() {
		return (this.playController).undoable();
	}
	
}
