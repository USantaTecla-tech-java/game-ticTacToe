package usantatecla.tictactoe.views.console.menus;

import usantatecla.tictactoe.controllers.core.PlayController;
import usantatecla.utils.Menu;

public class PlayMenu extends Menu {

    public PlayMenu(PlayController playController) {
		this.addCommand(new MovementCommand(playController));
		this.addCommand(new UndoCommand(playController));
		this.addCommand(new RedoCommand(playController));
		this.addCommand(new ExitCommand(playController));
	}
    
}