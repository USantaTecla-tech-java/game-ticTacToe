package usantatecla.tictactoe.views.console.core;

import usantatecla.tictactoe.controllers.core.PlayController;
import usantatecla.tictactoe.views.console.menus.PlayMenu;

class PlayView {

    void interact(PlayController playController) {
		new PlayMenu(playController).execute();
	}
}