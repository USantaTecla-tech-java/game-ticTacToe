package usantatecla.tictactoe;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.controllers.ResumeController;
import usantatecla.tictactoe.controllers.StartController;
import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.views.ViewFactory;

abstract class TicTacToe {

    private Game game;
    private ViewFactory viewFactory;
    private StartController startController;
    private PlayController playController;
    private ResumeController resumeController;

    protected TicTacToe() {
        this.game = new Game();
        this.viewFactory = this.createViewFactory();
        this.startController = new StartController(this.game, this.viewFactory);
        this.playController = new PlayController(this.game, this.viewFactory);
        this.resumeController = new ResumeController(this.game, this.viewFactory);
    }

    protected abstract ViewFactory createViewFactory();

    protected void play() {
        do {
            this.startController.control();
            this.playController.control();
        } while (this.resumeController.control());
    }

}
