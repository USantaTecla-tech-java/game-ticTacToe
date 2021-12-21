package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.views.Message;

public class StartView implements usantatecla.tictactoe.views.StartView {

    public void write() {
        new MessageView().writeln(Message.TITLE);
    }

}
