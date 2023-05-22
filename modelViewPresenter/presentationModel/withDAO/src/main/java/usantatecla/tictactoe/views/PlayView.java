package usantatecla.tictactoe.views;

import usantatecla.tictactoe.controllers.interfaces.PlayController;
import usantatecla.tictactoe.views.menus.PlayMenu;

class PlayView {

    void interact(PlayController playController) {
		new PlayMenu(playController).execute();
	}
}