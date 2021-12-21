package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.types.Coordinate;
import usantatecla.tictactoe.views.Message;
import usantatecla.utils.views.Console;

class BoardView {

    void write(Game game) {
        new MessageView().writeln(Message.HORIZONTAL_LINE);
        for (int i = 0; i < Coordinate.DIMENSION; i++) {
            new MessageView().write(Message.VERTICAL_LINE);
            for (int j = 0; j < Coordinate.DIMENSION; j++) {
                new ColorView().write(game.getColor(new Coordinate(i, j)));
                new MessageView().write(Message.VERTICAL_LINE);
            }
            Console.getInstance().writeln();
        }
        new MessageView().writeln(Message.HORIZONTAL_LINE);
    }

}
