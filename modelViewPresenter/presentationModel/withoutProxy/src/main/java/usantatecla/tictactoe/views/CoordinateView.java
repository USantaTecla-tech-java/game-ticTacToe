package usantatecla.tictactoe.views;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.types.Error;
import usantatecla.utils.Console;

class CoordinateView {

    PlayController playController;

    CoordinateView(PlayController playController) {
        this.playController = playController;
    }

    Coordinate read(String title) {
        Coordinate coordinate;
        do {
            Console.getInstance().writeln(title);
            int row = Console.getInstance().readInt(MessageView.READ_ROW.getMessage()) - 1;
            int column = Console.getInstance().readInt(MessageView.READ_COLUMN.getMessage()) - 1;
            coordinate = new Coordinate(row, column);
            assert playController.isCoordinateValid(coordinate);
            if (!this.playController.isCoordinateValid(coordinate)) {
                new ErrorView(Error.NOT_VALID).writeln();
            }
        } while (!this.playController.isCoordinateValid(coordinate));
        return coordinate;
    }
}