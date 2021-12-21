package usantatecla.tictactoe;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.views.graphics.GraphicsView;

class GraphicsTicTacToe extends TicTacToe{

    @Override
    protected GraphicsView createView(Logic logic){
        return new GraphicsView(logic);
    }

    public static void main(String[] args) {
        new GraphicsTicTacToe().play();
    }
    
}
