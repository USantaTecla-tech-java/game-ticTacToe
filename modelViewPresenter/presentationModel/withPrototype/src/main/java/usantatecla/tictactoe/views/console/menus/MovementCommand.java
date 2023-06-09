package usantatecla.tictactoe.views.console.menus;

import usantatecla.tictactoe.controllers.core.PlayController;
import usantatecla.tictactoe.models.core.Coordinate;
import usantatecla.tictactoe.models.types.PlayerType;
import usantatecla.tictactoe.views.console.models.BoardView;
import usantatecla.tictactoe.views.console.models.GameView;
import usantatecla.tictactoe.views.console.models.MachinePlayerView;
import usantatecla.tictactoe.views.console.models.MessageView;
import usantatecla.tictactoe.views.console.models.PlayerView;
import usantatecla.tictactoe.views.console.models.UserPlayerView;

public class MovementCommand extends Command {

    MovementCommand(PlayController playController) {
        super(MessageView.PROPOSE_COMMAND.getMessage(), playController);
    }

    @Override
    protected void execute() {
        PlayController playController = (PlayController) this.acceptorController;
        new BoardView(playController).write();
        PlayerView playerView = (playController).getTypeOfTokenPlayerFromTurn() == PlayerType.USER_PLAYER
                ? new UserPlayerView((playController))
                : new MachinePlayerView((playController));
        if (!(playController).isBoardComplete()) {
            Coordinate coordinate = playerView.readCoordinateToPut();
            (playController).putTokenPlayerFromTurn(coordinate);
        } else {
            Coordinate[] coordinates = playerView.readCoordinatesToMove();
            (playController).moveTokenPlayerFromTurn(coordinates);
        }
        new GameView((playController));
    }

    @Override
	protected boolean isActive() {
		return true;
	}
    
}