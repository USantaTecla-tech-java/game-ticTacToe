package usantatecla.tictactoe.distributed.client;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.distributed.client.proxies.PlayControllerProxy;
import usantatecla.tictactoe.distributed.client.proxies.ResumeControllerProxy;
import usantatecla.tictactoe.distributed.client.proxies.SessionProxy;
import usantatecla.tictactoe.distributed.client.proxies.StartControllerProxy;
import usantatecla.tictactoe.distributed.server.dispatchers.TCPIP;
import usantatecla.tictactoe.types.StateValue;

public class LogicProxy extends Logic {
	
	private TCPIP tcpip;
	
	public LogicProxy() {
		this.tcpip = TCPIP.createClientSocket();
		this.session = new SessionProxy(this.tcpip);
		this.acceptorControllers.put(StateValue.INITIAL, new StartControllerProxy(this.session,this.tcpip));
		this.acceptorControllers.put(StateValue.IN_GAME, new PlayControllerProxy(this.session,this.tcpip));
		this.acceptorControllers.put(StateValue.RESUME, new ResumeControllerProxy(this.session,this.tcpip));
		this.acceptorControllers.put(StateValue.EXIT, null);
	}

	public void close() {
		this.tcpip.close();
	}
	
}
