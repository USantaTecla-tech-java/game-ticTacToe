package usantatecla.tictactoe.launchers.standalone;

import usantatecla.tictactoe.controllers.core.Logic;
import usantatecla.tictactoe.controllers.implementation.LogicImplementation;
import usantatecla.tictactoe.launchers.TicTacToe;

public class TicTacToeStandalone extends TicTacToe {

    @Override
	protected Logic createLogic() {
		return new LogicImplementation();
	}
	
	public static void main(String[] args) {
		new TicTacToeStandalone().play();
	}
    
}