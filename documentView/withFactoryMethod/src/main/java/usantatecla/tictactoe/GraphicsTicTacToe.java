package usantatecla.tictactoe;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.views.graphics.GraphicsView;
import usantatecla.tictactoe.views.View;

public class GraphicsTicTacToe extends TicTacToe {
	
	@Override
	protected View createView(Game game) {
		return new GraphicsView(game);
	}

	public static void main(String[] args) {
		new GraphicsTicTacToe().play();
	}

}