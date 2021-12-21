package usantatecla.tictactoe;

import usantatecla.tictactoe.views.console.ConsoleView;

class ConsoleTicTacToe extends TicTacToe {

    @Override
    protected ConsoleView createView() {
        return new ConsoleView(this.startController, this.playController, this.resumeController);
    }

    public static void main(String[] args) {
        new ConsoleTicTacToe().play();
    }

}
