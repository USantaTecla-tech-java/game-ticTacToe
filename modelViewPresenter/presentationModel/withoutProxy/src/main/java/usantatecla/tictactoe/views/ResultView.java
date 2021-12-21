package usantatecla.tictactoe.views;

import usantatecla.tictactoe.types.Token;
import usantatecla.utils.Console;

class ResultView {

    void writeln(int winner) {
        Console.getInstance().write(Token.values()[winner].toString().charAt(0));
        Console.getInstance().writeln(MessageView.PLAYER_WIN.getMessage());
    }
}