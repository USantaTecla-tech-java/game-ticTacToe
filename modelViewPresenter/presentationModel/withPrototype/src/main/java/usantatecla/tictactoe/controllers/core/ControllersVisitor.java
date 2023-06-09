package usantatecla.tictactoe.controllers.core;

public interface ControllersVisitor {

    void visit(StartController startController);
	
	void visit(PlayController playController);

	void visit(SaveController saveController);
	
	void visit(ResumeController resumeController);
    
}