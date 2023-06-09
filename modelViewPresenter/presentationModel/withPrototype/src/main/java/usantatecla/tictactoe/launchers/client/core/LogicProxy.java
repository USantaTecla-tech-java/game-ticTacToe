package usantatecla.tictactoe.launchers.client.core;

import usantatecla.tictactoe.controllers.core.Logic;
import usantatecla.tictactoe.launchers.client.proxies.PlayControllerProxy;
import usantatecla.tictactoe.launchers.client.proxies.ResumeControllerProxy;
import usantatecla.tictactoe.launchers.client.proxies.SaveControllerProxy;
import usantatecla.tictactoe.launchers.client.proxies.StartControllerProxy;
import usantatecla.tictactoe.launchers.server.dispatchers.core.TCPIP;
import usantatecla.tictactoe.models.types.StateValue;

public class LogicProxy extends Logic {
	
	private TCPIP tcpip;
	
	public LogicProxy() {
		this.tcpip = TCPIP.createClientSocket();
		this.session = new SessionProxy(this.tcpip);
		this.acceptorControllers.put(StateValue.INITIAL, new StartControllerProxy(this.session, this.tcpip));
		this.acceptorControllers.put(StateValue.IN_GAME, new PlayControllerProxy(this.session, this.tcpip));
		this.acceptorControllers.put(StateValue.SAVING, new SaveControllerProxy(this.session, this.tcpip));
		this.acceptorControllers.put(StateValue.RESUME, new ResumeControllerProxy(this.session, this.tcpip));
		this.acceptorControllers.put(StateValue.EXIT, null);
	}

	public void close() {
		this.tcpip.close();
	}
	
}
