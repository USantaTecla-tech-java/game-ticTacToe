package usantatecla.tictactoe.distributed.client.proxies;

import usantatecla.tictactoe.distributed.server.dispatchers.FrameType;
import usantatecla.tictactoe.models.Session;
import usantatecla.tictactoe.types.StateValue;
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
