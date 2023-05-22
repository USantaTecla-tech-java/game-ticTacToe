package usantatecla.tictactoe.views.menus;

import usantatecla.tictactoe.controllers.interfaces.StartController;
import usantatecla.utils.Menu;

public class StartMenu extends Menu {

	public StartMenu(StartController startController) {
		this.addCommand(new NewGameCommand(startController));
		this.addCommand(new OpenGameCommand(startController));
	}
}
