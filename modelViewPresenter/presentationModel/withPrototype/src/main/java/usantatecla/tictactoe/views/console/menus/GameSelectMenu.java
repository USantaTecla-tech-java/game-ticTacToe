package usantatecla.tictactoe.views.console.menus;

import usantatecla.tictactoe.controllers.core.StartController;
import usantatecla.utils.Menu;

class GameSelectMenu extends Menu {

	GameSelectMenu(StartController startController) {
		String[] gamesNames = startController.getGamesNames();
		for (String title : gamesNames) {
			this.addCommand(new GameSelectCommand(title, startController));
		}
	}

}
