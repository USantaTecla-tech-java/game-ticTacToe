package usantatecla.tictactoe.views.console.menus;

import usantatecla.tictactoe.controllers.core.PlayController;
import usantatecla.tictactoe.views.console.models.GameView;
import usantatecla.tictactoe.views.console.models.MessageView;

class RedoCommand extends Command{

	private PlayController playController;
	
	RedoCommand(PlayController playController) {
		super(MessageView.REDO_COMMAND.getMessage(), playController);
		this.playController = (PlayController) this.acceptorController;
	}

	@Override
	protected void execute() {
		(this.playController).redo();
		new GameView((this.playController));
		
	}

	@Override
	protected boolean isActive() {
		return (this.playController).redoable();
	}

}
