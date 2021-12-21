package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.models.Board;
import usantatecla.tictactoe.models.Player;
import usantatecla.tictactoe.views.ViewFactory;

public class ConsoleViewFactory extends ViewFactory {

    @Override
    public BoardView createBoardView(Board board) {
        return new BoardView(board);
    }

    @Override
    public CoordinateView createCoordinateView() {
        return new CoordinateView();
    }

    @Override
    public PlayerView createPlayerView(Player player) {
        return new PlayerView(player);
    }

    @Override
    public ResumeView createResumeView() {
        return new ResumeView();
    }

    @Override
    public StartView createStartView() {
        return new StartView();
    }

    @Override
    public ErrorView createErrorView() {
        return new ErrorView();
    }

}
