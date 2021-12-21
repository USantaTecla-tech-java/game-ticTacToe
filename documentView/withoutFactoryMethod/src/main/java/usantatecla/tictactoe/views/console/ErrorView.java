package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.types.Error;
import usantatecla.utils.views.Console;

public class ErrorView extends usantatecla.tictactoe.views.ErrorView {

    @Override
    public void writeln(Error error) {
        if (!error.isNull()) {
            Console.getInstance().writeln(usantatecla.tictactoe.views.ErrorView.MESSAGES[error.ordinal()]);
        }
    }

}
