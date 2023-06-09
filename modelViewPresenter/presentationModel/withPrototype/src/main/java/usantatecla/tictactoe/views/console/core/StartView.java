package usantatecla.tictactoe.views.console.core;

import usantatecla.tictactoe.controllers.core.StartController;
import usantatecla.tictactoe.views.console.menus.StartMenu;
import usantatecla.tictactoe.views.console.models.MessageView;
import usantatecla.utils.WithConsoleView;

class StartView extends WithConsoleView {

    void interact(StartController startController) {
		this.console.writeln(MessageView.START_GAME.getMessage());
		new StartMenu(startController).execute();
	}
}