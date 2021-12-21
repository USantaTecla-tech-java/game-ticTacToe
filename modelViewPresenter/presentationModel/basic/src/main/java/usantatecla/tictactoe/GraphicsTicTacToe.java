package usantatecla.tictactoe;

import usantatecla.tictactoe.views.graphics.GraphicsView;

class GraphicsTicTacToe extends TicTacToe {

    @Override
    protected GraphicsView createView() {
        return new GraphicsView(this.startController, this.playController, this.resumeController);
    }

    public static void main(String[] args) {
        new GraphicsTicTacToe().play();
    }

}
