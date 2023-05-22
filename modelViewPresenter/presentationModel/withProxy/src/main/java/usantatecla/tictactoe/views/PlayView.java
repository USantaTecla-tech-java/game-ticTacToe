package usantatecla.tictactoe.views;

import usantatecla.tictactoe.controllers.interfaces.PlayController;

class PlayView {

    void interact(PlayController playController) {
		new PlayMenu(playController).execute();	
	}
}