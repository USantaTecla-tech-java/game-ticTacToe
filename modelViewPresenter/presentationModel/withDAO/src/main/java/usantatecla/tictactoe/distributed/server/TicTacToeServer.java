package usantatecla.tictactoe.distributed.server;

import usantatecla.tictactoe.daos.SessionImplementationDAO;
import usantatecla.tictactoe.distributed.server.dispatchers.DispatcherPrototype;

public class TicTacToeServer {

	private DispatcherPrototype dispatcherPrototype;

	private LogicImplementationServer logic;

	private TicTacToeServer() {
		this.dispatcherPrototype = new DispatcherPrototype();
		this.logic = new LogicImplementationServer(new SessionImplementationDAO());
		this.logic.createDispatchers(this.dispatcherPrototype);
	}

	private void serve() {
		this.dispatcherPrototype.serve();
	}

	public static void main(String[] args) {
		new TicTacToeServer().serve();
	}

}
