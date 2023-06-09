package usantatecla.tictactoe.views;

import usantatecla.tictactoe.controllers.core.PlayController;

public class GameView {

    GameView(PlayController playController) {
        new BoardView(playController).write();
        if (playController.isTicTacToe()) {
            new ResultView().writeln(playController.getValueFromTurn());
            playController.continueState();
        }
    }
    
}