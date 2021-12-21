package usantatecla.tictactoe.views;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.controllers.ResumeController;
import usantatecla.tictactoe.controllers.StartController;

public interface View {

    void start(StartController startController);
    void play(PlayController playController);
    boolean resume(ResumeController resumeController);

}
