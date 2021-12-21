package usantatecla.tictactoe.types;

public enum Error {

	NOT_EMPTY,
	NOT_OWNER,
	SAME_COORDINATES,
	NOT_VALID,
	NULL;

	public boolean isNull(){
		return this == Error.NULL;
	}

}
