package usantatecla.tictactoe.controllers.implementation;

import usantatecla.tictactoe.controllers.interfaces.StartController;
import usantatecla.tictactoe.daos.SessionImplementationDAO;
import usantatecla.tictactoe.models.Session;
import usantatecla.tictactoe.models.SessionImplementation;

public class StartControllerImplementation extends StartController {
	private SessionImplementationDAO sessionImplementationDAO;

	private SessionImplementation sessionImplementation;

	public StartControllerImplementation(Session session, SessionImplementationDAO sessionImplementationDAO) {
		super(session);
		this.sessionImplementationDAO = sessionImplementationDAO;
		this.sessionImplementation = ((SessionImplementation) this.session);
	}

	public void createPlayers(int numberOfUsers) {
		this.sessionImplementation.createPlayers(numberOfUsers);
	}

	@Override
	public void start() {
		this.sessionImplementationDAO.associate((SessionImplementation)this.session);
		this.sessionImplementation.next();		
	}

	@Override
	public void start(String name) {
		this.sessionImplementationDAO.load(name);
	}

	@Override
	public String[] getGamesNames() {
		return this.sessionImplementationDAO.getGamesNames();
	}

}
