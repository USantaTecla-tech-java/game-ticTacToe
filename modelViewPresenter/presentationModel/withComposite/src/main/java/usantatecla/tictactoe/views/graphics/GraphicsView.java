package usantatecla.tictactoe.views.graphics;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.controllers.ResumeController;
import usantatecla.tictactoe.controllers.StartController;
import usantatecla.tictactoe.views.View;

public class GraphicsView implements View {

    public void visit(StartController startController) {
    }

    public void visit(PlayController playController) {
    }

    public boolean visit(ResumeController resumeController) {
        return true;
    }

}
