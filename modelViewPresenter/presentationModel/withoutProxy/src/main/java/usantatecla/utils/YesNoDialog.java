package usantatecla.utils;

public class YesNoDialog {

	private static final char AFFIRMATIVE = 'y';
	private static final char NEGATIVE = 'n';
	private static final String SUFFIX = "? (" +
		YesNoDialog.AFFIRMATIVE+"/" + 
		YesNoDialog.NEGATIVE+"): ";
	private static final String MESSAGE = "The value must be '" + 
		YesNoDialog.AFFIRMATIVE + "' or '" + 
		YesNoDialog.NEGATIVE + "'";
	private char answer;

	public boolean read(String message) {
		assert message != null;
		
		Console console = Console.getInstance();
		boolean error;
		do {
			console.write(message);
			this.answer = console.readChar(YesNoDialog.SUFFIX);
			error = !this.isAffirmative() && !this.isNegative();
			if (error) {
				console.writeln(YesNoDialog.MESSAGE);
			}
		} while (error);
		return this.isAffirmative();
	}

	private boolean isAffirmative() {
		return this.getAnswer() == YesNoDialog.AFFIRMATIVE;
	}

	private char getAnswer(){
		return Character.toLowerCase(this.answer);
	}

	private boolean isNegative() {
		return Character.toLowerCase(this.answer) == YesNoDialog.NEGATIVE;
	}

}
