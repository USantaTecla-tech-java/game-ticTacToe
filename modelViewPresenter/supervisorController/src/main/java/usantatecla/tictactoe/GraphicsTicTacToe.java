package usantatecla.tictactoe;

import usantatecla.tictactoe.views.graphics.GraphicsViewFactory;

class GraphicsTicTacToe extends TicTacToe {

    @Override
    protected GraphicsViewFactory createViewFactory() {
        return new GraphicsViewFactory();
    }

    public static void main(String[] args) {
        new GraphicsTicTacToe().play();
    }

}
