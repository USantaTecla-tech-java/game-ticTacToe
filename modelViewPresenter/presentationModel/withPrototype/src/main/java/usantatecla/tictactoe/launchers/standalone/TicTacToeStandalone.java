package usantatecla.tictactoe.launchers.standalone;

import java.util.HashMap;
import java.util.Map;

import usantatecla.tictactoe.controllers.implementation.LogicImplementation;
import usantatecla.tictactoe.daos.core.SessionImplementationDAO;
import usantatecla.tictactoe.daos.dataBase.SessionImplementationDBDAO;
import usantatecla.tictactoe.daos.files.SessionImplementationFileDAO;
import usantatecla.tictactoe.launchers.core.TicTacToe;

public class TicTacToeStandalone extends TicTacToe {

	private Map<String, SessionImplementationDAO> sessionDaoMap;

	public TicTacToeStandalone() {
		super();
		this.sessionDaoMap = new HashMap<String, SessionImplementationDAO>();
		this.sessionDaoMap.put("file", new SessionImplementationFileDAO());
		this.sessionDaoMap.put("db", new SessionImplementationDBDAO());
	}

    public void play(String arg) {
		SessionImplementationDAO sessionImplementationDAO = this.sessionDaoMap.get(arg);
		if (sessionImplementationDAO == null) {
			System.out.println("Introduce 'file' para ficheros o 'db' para bases de datos");
			System.exit(0);
		}
		this.logic = new LogicImplementation(sessionImplementationDAO);
		super.play();
	}
	
	public static void main(String[] args) {
		new TicTacToeStandalone().play(args[0]);
	}
    
}