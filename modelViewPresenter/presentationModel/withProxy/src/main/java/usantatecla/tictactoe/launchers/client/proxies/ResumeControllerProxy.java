package usantatecla.tictactoe.launchers.client.proxies;

import usantatecla.tictactoe.controllers.core.ResumeController;
import usantatecla.tictactoe.launchers.server.dispatchers.FrameType;
import usantatecla.tictactoe.models.Session;
import usantatecla.utils.TCPIP;

public class ResumeControllerProxy extends ResumeController {
	
	private TCPIP tcpip;

	public ResumeControllerProxy(Session session, TCPIP tcpip) {
		super(session);
		this.tcpip = tcpip;
	}

	@Override
	public void resume(boolean newGame) {
		this.tcpip.send(FrameType.NEW_GAME.name());
		this.tcpip.send(newGame);	
	}

}
