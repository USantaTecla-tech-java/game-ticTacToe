package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.controllers.interfaces.PlayController;
import usantatecla.tictactoe.controllers.interfaces.ResumeController;
import usantatecla.tictactoe.controllers.interfaces.StartController;

public interface ControllersVisitor {

    void visit(StartController startController);
	
	void visit(PlayController playController);
	
	void visit(ResumeController resumeController);
    
}