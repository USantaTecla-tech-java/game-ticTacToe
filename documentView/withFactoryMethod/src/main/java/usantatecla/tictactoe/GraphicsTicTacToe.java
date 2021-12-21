package usantatecla.tictactoe;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.views.graphics.GraphicsView;

public class GraphicsTicTacToe extends TicTacToe {
	
	@Override
	protected GraphicsView createView(Game game) {
		return new GraphicsView(game);
	}

	public static void main(String[] args) {
		new GraphicsTicTacToe().play();
	}

}