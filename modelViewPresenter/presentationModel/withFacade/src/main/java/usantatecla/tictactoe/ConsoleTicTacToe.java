package usantatecla.tictactoe;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.views.console.ConsoleView;

class ConsoleTicTacToe extends TicTacToe {

	@Override
	protected ConsoleView createView(Logic logic){
		return new ConsoleView(logic);
	}

	public static void main(String[] args) {
		new ConsoleTicTacToe().play();
	}

}
