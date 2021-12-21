package usantatecla.tictactoe;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.views.console.ConsoleView;

class ConsoleTicTacToe {

	private Game game;
	private ConsoleView consoleView;

	private ConsoleTicTacToe() {
		this.game = new Game();
		this.consoleView = new ConsoleView(this.game);
	}

	private void play() {
		do {
			this.consoleView.start();
			this.consoleView.play();
		} while (this.consoleView.resume());
	}

	public static void main(String[] args) {
		new ConsoleTicTacToe().play();
	}

}
