package usantatecla.tictactoe.launchers.server.core;

import java.util.HashMap;
import java.util.Map;

import usantatecla.tictactoe.daos.core.SessionImplementationDAO;
import usantatecla.tictactoe.daos.dataBase.SessionImplementationDBDAO;
import usantatecla.tictactoe.daos.files.SessionImplementationFileDAO;
import usantatecla.tictactoe.launchers.server.dispatchers.core.DispatcherPrototype;

public class TicTacToeServer {

	private Map<String, SessionImplementationDAO> sessionDaoMap;

	private LogicImplementationServer logic;

	private DispatcherPrototype dispatcherPrototype;

	protected TicTacToeServer() {
		this.sessionDaoMap = new HashMap<String, SessionImplementationDAO>();
		this.sessionDaoMap.put("file", new SessionImplementationFileDAO());
		this.sessionDaoMap.put("db", new SessionImplementationDBDAO());
		this.dispatcherPrototype = new DispatcherPrototype();
	}

	protected void serve() {
		this.dispatcherPrototype.serve();
	}

	public void play(String arg) {
		SessionImplementationDAO sessionImplementationDAO = this.sessionDaoMap.get(arg);
		if (sessionImplementationDAO == null) {
			System.out.println("Introduce 'file' para ficheros o 'db' para bases de datos");
			System.exit(0);
		}
		this.logic = new LogicImplementationServer(sessionImplementationDAO);
		this.logic.createDispatchers(this.dispatcherPrototype);
		this.serve();
	}

	public static void main(String[] args) {
		new TicTacToeServer().play("file");
	}

}
