package usantatecla.tictactoe.views;

public abstract class ViewFactory {

    public abstract BoardView createBoardView();
    public abstract CoordinateView createCoordinateView();
    public abstract PlayerView createPlayerView();
    public abstract ResumeView createResumeView();
    public abstract StartView createStartView();
    public abstract ErrorView createErrorView();

}
