package usantatecla.tictactoe.launchers.server.dispatchers;

import usantatecla.tictactoe.controllers.interfaces.PlayController;

public class DimensionDispatcher extends Dispatcher {
    
    public DimensionDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
		this.tcpip.send(((PlayController)this.acceptorController).getCoordinateDimension());
	}
}