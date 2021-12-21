package usantatecla.tictactoe;

import usantatecla.tictactoe.views.graphics.GraphicsView;

class GraphicsTicTacToe extends TicTacToe{

    @Override
    protected GraphicsView createView(){
        return new GraphicsView();
    }

    public static void main(String[] args) {
        new GraphicsTicTacToe().play();
    }
    
}
