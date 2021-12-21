package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.types.Coordinate;
import usantatecla.tictactoe.views.Message;
import usantatecla.utils.views.Console;

public class BoardView extends usantatecla.tictactoe.views.BoardView {

    @Override
    public void write() {
        new MessageView().writeln(Message.HORIZONTAL_LINE);
        for (int i = 0; i < Coordinate.DIMENSION; i++) {
            new MessageView().write(Message.VERTICAL_LINE);
            for (int j = 0; j < Coordinate.DIMENSION; j++) {
                new ColorView().write(this.colors.get(i * Coordinate.DIMENSION + j));
                new MessageView().write(Message.VERTICAL_LINE);
            }
            Console.getInstance().writeln();
        }
        new MessageView().writeln(Message.HORIZONTAL_LINE);
    }

}
