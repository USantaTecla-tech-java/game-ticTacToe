package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.StartController;
import usantatecla.tictactoe.views.Message;

class StartView{

    private StartController startController;

    StartView(StartController startController) {
        this.startController = startController;
    }

    void interact() {
        new MessageView().writeln(Message.TITLE);
        new BoardView().write(this.startController);
    }

}
