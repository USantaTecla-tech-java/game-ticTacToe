package usantatecla.tictactoe.daos.dataBase;

import java.sql.Connection;

public interface DBDAO {

	void save (String name, Connection connection, boolean exists);
	
	void load (String name, Connection connection);

}
