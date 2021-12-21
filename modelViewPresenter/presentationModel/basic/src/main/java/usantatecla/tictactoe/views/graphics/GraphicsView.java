package usantatecla.tictactoe.views.graphics;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.controllers.ResumeController;
import usantatecla.tictactoe.controllers.StartController;
import usantatecla.tictactoe.views.View;

public class GraphicsView extends View {

    public GraphicsView(StartController startController, PlayController playController,
                        ResumeController resumeController) {
        super(startController, playController, resumeController);
    }

    @Override
    public void start() {
    }

    @Override
    public void play() {
    }

    @Override
    public boolean resume() {
        return true;
    }

}
