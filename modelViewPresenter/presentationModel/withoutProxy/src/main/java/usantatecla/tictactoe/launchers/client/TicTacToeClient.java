package usantatecla.tictactoe.launchers.client;

import usantatecla.tictactoe.launchers.TicTacToe;

public class TicTacToeClient extends TicTacToe{
	
	@Override
	protected boolean isStandalone() {
		return false;
	}
	
	public static void main(String[] args) {
		new TicTacToeClient().play();
	}

}
