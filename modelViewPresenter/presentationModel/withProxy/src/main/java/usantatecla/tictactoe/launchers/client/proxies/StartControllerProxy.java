package usantatecla.tictactoe.launchers.client.proxies;

import usantatecla.tictactoe.controllers.interfaces.StartController;
import usantatecla.tictactoe.launchers.server.dispatchers.FrameType;
import usantatecla.tictactoe.models.Session;
import usantatecla.utils.TCPIP;

public class StartControllerProxy extends StartController {
	
	private TCPIP tcpip;

	public StartControllerProxy(Session session, TCPIP tcpip) {
		super(session);
		this.tcpip = tcpip;
	}

	@Override
	public void start() {
		this.tcpip.send(FrameType.START.name());
	}

	@Override
	public void createPlayers(int numberOfUsers) {
		this.tcpip.send(FrameType.CREATE_PLAYERS.name());
		this.tcpip.send(numberOfUsers);
	}

}
