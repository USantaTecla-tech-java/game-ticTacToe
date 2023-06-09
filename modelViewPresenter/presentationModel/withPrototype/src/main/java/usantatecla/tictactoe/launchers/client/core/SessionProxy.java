package usantatecla.tictactoe.launchers.client.core;

import usantatecla.tictactoe.launchers.server.dispatchers.core.FrameType;
import usantatecla.tictactoe.models.core.Session;
import usantatecla.tictactoe.models.types.StateValue;
import usantatecla.utils.TCPIP;

public class SessionProxy implements Session {
	
	private TCPIP tcpip;

	public SessionProxy(TCPIP tcpip) {
		this.tcpip = tcpip;
	}
	
	public StateValue getValueState() {
		this.tcpip.send(FrameType.STATE.name());
		return StateValue.values()[this.tcpip.receiveInt()];
	}

}
