package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.views.Message;
import usantatecla.tictactoe.views.WithGameView;

class StartView extends WithGameView {

    StartView(Game game) {
        super(game);
    }

    void interact() {
        new MessageView().writeln(Message.TITLE);
        new BoardView().write(this.game);
    }

}
