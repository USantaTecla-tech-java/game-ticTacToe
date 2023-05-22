package usantatecla.tictactoe.launchers.standalone;

import usantatecla.tictactoe.launchers.TicTacToe;

public class TicTacToeStandalone extends TicTacToe {

    @Override
	protected boolean isStandalone() {
		return true;
	}
	
	public static void main(String[] args) {
		new TicTacToeStandalone().play();
	}
    
}