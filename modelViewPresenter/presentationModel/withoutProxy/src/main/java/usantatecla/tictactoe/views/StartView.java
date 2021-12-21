package usantatecla.tictactoe.views;

import usantatecla.tictactoe.controllers.StartController;
import usantatecla.tictactoe.models.Turn;
import usantatecla.utils.Console;
import usantatecla.utils.PlayersDialog;

class StartView {

    void interact(StartController startController) {
		startController.start();
		Console.getInstance().writeln(MessageView.START_GAME.getMessage());
		int numberOfUsers = new PlayersDialog().read(Turn.NUMBER_PLAYERS);
		startController.createPlayers(numberOfUsers);
	}
}