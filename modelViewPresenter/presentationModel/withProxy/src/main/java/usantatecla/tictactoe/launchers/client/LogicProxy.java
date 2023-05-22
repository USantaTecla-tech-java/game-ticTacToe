package usantatecla.tictactoe.launchers.client;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.launchers.client.proxies.PlayControllerProxy;
import usantatecla.tictactoe.launchers.client.proxies.ResumeControllerProxy;
import usantatecla.tictactoe.launchers.client.proxies.SessionProxy;
import usantatecla.tictactoe.launchers.client.proxies.StartControllerProxy;
import usantatecla.tictactoe.launchers.server.dispatchers.TCPIP;
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
