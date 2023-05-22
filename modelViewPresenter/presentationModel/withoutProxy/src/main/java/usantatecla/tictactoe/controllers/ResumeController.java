package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.launchers.server.dispatchers.FrameType;
import usantatecla.tictactoe.launchers.server.dispatchers.TCPIP;
import usantatecla.tictactoe.models.Session;

public class ResumeController extends AcceptorController {

	public ResumeController(Session session, TCPIP tcpip) {
		super(session, tcpip);
	}

	public void resume(boolean newGame) {
		if (this.tcpip == null) {
			if (newGame) {
				this.session.newGame();
			} else {
				this.session.next();
			}
		} else {
			this.tcpip.send(FrameType.NEW_GAME.name());
			this.tcpip.send(newGame);
		}
	}

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}

}
