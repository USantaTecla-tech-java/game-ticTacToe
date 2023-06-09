package usantatecla.tictactoe.views;

import usantatecla.tictactoe.controllers.core.PlayController;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.utils.WithConsoleView;

class BoardView extends WithConsoleView {
    
    private PlayController playController;

    BoardView(PlayController playController) {
        this.playController = playController;
    }

    void write() {
        this.console.writeln(MessageView.SEPARATOR.getMessage());
		for (int i = 0; i < this.playController.getCoordinateDimension(); i++) {
			this.printRowBoard(i);
        }
        this.console.writeln(MessageView.SEPARATOR.getMessage());
	}

	private void printRowBoard(int row) {
        this.console.write(MessageView.VERTICAL_LINE_LEFT.getMessage());
		for (int j = 0; j < this.playController.getCoordinateDimension(); j++) {
			this.printSquareBoard(new Coordinate(row, j));
		}
		this.console.writeln();
	}

	private void printSquareBoard(Coordinate coordinate) {
		if (this.playController.isEmptyToken(coordinate)) {
            this.console.write(MessageView.EMPTY.getMessage());
		} else {
			this.console.write(this.playController.getTokenChar(coordinate));
        }
        this.console.write(MessageView.VERTICAL_LINE_CENTERED.getMessage());
	}
}