package usantatecla.tictactoe.views.console.models;

import usantatecla.tictactoe.controllers.core.PlayController;

public class GameView {

    public GameView(PlayController playController) {
        new BoardView(playController).write();
        if (playController.isTicTacToe()) {
            new ResultView().writeln(playController.getValueFromTurn());
            playController.continueState();
        }
    }
    
}