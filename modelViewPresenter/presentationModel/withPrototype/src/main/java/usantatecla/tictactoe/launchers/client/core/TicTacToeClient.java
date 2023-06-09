package usantatecla.tictactoe.launchers.client.core;

import usantatecla.tictactoe.launchers.core.TicTacToe;

public class TicTacToeClient extends TicTacToe{

	public TicTacToeClient() {
		this.logic = new LogicProxy();
	}

	@Override
	protected void play() {
		super.play();
		((LogicProxy) this.logic).close();
	}
	
	public static void main(String[] args) {
		new TicTacToeClient().play();
	}

}
