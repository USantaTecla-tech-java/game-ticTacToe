package usantatecla.tictactoe.views;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.models.Turn;
import usantatecla.utils.views.BoundedIntDialog;

class StartView extends WithGameView {

    StartView(Game game) {
		super(game);
	}

    void interact() {
		Message.TITLE.writeln();
		BoundedIntDialog dialog = new BoundedIntDialog(0, Turn.NUMBER_PLAYERS);
		this.game.setUsers(dialog.read(Message.NUMBER_PLAYERS.toString()));
		new BoardView().write(this.game);
	}

}
