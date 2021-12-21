package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.utils.views.Menu;

class PlayMenu extends Menu {

    PlayMenu(PlayController playController) {
        this.addCommand(new ActionCommand(playController));
        this.addCommand(new UndoCommand(playController));
        this.addCommand(new RedoCommand(playController));
    }

}
