package usantatecla.tictactoe.views;

import usantatecla.tictactoe.controllers.core.AcceptorController;
import usantatecla.tictactoe.controllers.core.ControllersVisitor;
import usantatecla.tictactoe.controllers.core.PlayController;
import usantatecla.tictactoe.controllers.core.ResumeController;
import usantatecla.tictactoe.controllers.core.StartController;

public class View implements ControllersVisitor {

    private StartView startView;

	private PlayView playView;

	private ResumeView resumeView;

	public View() {
		this.startView = new StartView();
		this.playView = new PlayView();
		this.resumeView = new ResumeView();
	}

	public void interact(AcceptorController acceptorController) {
		acceptorController.accept(this);
	}

	
	public void visit(StartController startController) {
		this.startView.interact(startController);
	}

	
	public void visit(PlayController playController) {
		this.playView.interact(playController);
	}

	
	public void visit(ResumeController resumeController) {
		this.resumeView.interact(resumeController);
	}
}