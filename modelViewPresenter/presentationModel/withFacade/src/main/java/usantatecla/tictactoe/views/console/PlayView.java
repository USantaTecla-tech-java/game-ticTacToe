package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.views.Message;
import usantatecla.tictactoe.views.WithLogicView;

class PlayView extends WithLogicView {

    PlayView(Logic logic) {
        super(logic);
    }

    void interact() {
        do {
            new PlayerView(this.logic).interact();
            this.logic.next();
            new BoardView().write(this.logic);
        } while (!this.logic.isTicTacToe());
        new MessageView().writeln(Message.PLAYER_WIN, this.logic.getActiveColor().name());
    }

}
