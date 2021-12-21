package usantatecla.tictactoe.views;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.utils.Console;

class BoardView {
    
    private PlayController playController;

    BoardView(PlayController playController) {
        this.playController = playController;
    }

    void write() {
		Console.getInstance().writeln(MessageView.SEPARATOR.getMessage());
		for (int i = 0; i < this.playController.getCoordinateDimension(); i++) {
			this.printRowBoard(i);
        }
		Console.getInstance().writeln(MessageView.SEPARATOR.getMessage());
	}

	private void printRowBoard(int row) {
		Console.getInstance().write(MessageView.VERTICAL_LINE_LEFT.getMessage());
		for (int j = 0; j < this.playController.getCoordinateDimension(); j++) {
			this.printSquareBoard(new Coordinate(row, j));
		}
		Console.getInstance().writeln();
	}

	private void printSquareBoard(Coordinate coordinate) {
		if (this.playController.isEmptyToken(coordinate)) {
			Console.getInstance().write(MessageView.EMPTY.getMessage());
		} else {
			Console.getInstance().write(this.playController.getTokenChar(coordinate));
        }
		Console.getInstance().write(MessageView.VERTICAL_LINE_CENTERED.getMessage());
	}
}