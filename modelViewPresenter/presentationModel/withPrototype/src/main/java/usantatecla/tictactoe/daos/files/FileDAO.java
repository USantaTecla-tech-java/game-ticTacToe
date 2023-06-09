package usantatecla.tictactoe.daos.files;

import java.io.BufferedReader;
import java.io.FileWriter;

interface FileDAO {

	void save (FileWriter fileWriter);
	
	void load (BufferedReader bufferedReader);
	
}
