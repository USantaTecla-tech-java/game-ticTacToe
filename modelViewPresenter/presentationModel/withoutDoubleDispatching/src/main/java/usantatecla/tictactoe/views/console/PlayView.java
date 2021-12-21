package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.views.Message;

class PlayView {

    void interact(PlayController playController) {
        do {
            new PlayerView(playController).interact();
            playController.next();
            new BoardView().write(playController);
        } while (!playController.isTicTacToe());
        new MessageView().writeln(Message.PLAYER_WIN, playController.getActiveColor().name());
        playController.nextState();
    }

}
