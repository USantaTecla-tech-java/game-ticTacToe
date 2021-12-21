package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.views.Message;
import usantatecla.tictactoe.views.WithLogicView;

class StartView extends WithLogicView {

    StartView(Logic logic) {
        super(logic);
    }

    void interact() {
        new MessageView().writeln(Message.TITLE);
        new BoardView().write(this.logic);
    }

}
