package usantatecla.tictactoe.launchers.client;

import usantatecla.tictactoe.controllers.core.Logic;
import usantatecla.tictactoe.launchers.TicTacToe;

public class TicTacToeClient extends TicTacToe{

	private LogicProxy logicProxy;
	
	@Override
	protected Logic createLogic() {
		this.logicProxy = new LogicProxy();
		return this.logicProxy;
	}

	@Override
	protected void play() {
		super.play();
		this.logicProxy.close();
	}
	
	public static void main(String[] args) {
		new TicTacToeClient().play();
	}

}
