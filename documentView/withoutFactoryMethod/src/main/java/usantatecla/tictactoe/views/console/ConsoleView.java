package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.views.View;

public class ConsoleView extends View {

    private StartView startView;
    private PlayView playView;
    private ResumeView resumeView;

    public ConsoleView(Game game) {
        super(game);
        this.startView = new StartView(this.game);
        this.playView = new PlayView(this.game);
        this.resumeView = new ResumeView(this.game);
    }

    @Override
    public void start() {
        this.startView.interact();
    }

    @Override
    public void play() {
        this.playView.interact();
    }

    @Override
    public boolean resume() {
        return this.resumeView.interact();
    }

}
