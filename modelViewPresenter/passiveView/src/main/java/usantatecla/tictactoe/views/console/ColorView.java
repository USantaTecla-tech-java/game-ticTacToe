package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.types.Color;
import usantatecla.utils.views.Console;
class ColorView {

    void write(Color color) {
        String string = color.name();
        if (color.isNull()) {
            string = " ";
        }
        Console.getInstance().write(string);
    }
    
}
