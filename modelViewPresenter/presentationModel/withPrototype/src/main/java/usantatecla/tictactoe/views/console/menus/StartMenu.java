package usantatecla.tictactoe.views.console.menus;

import usantatecla.tictactoe.controllers.core.StartController;
import usantatecla.utils.Menu;

public class StartMenu extends Menu {

	public StartMenu(StartController startController) {
		this.addCommand(new NewGameCommand(startController));
		this.addCommand(new OpenGameCommand(startController));
	}
}
