package usantatecla.tictactoe.distributed.client;

import usantatecla.tictactoe.TicTacToe;

public class TicTacToeClient extends TicTacToe{
	
	@Override
	protected boolean isStandalone() {
		return false;
	}
	
	public static void main(String[] args) {
		new TicTacToeClient().play();
	}

}
