package usantatecla.tictactoe.types;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Color {

    X,
    O,
    NULL;

    public static Color get(int ordinal) {
        assert 0 <= ordinal  && ordinal < Color.NULL.ordinal();

        return Color.values()[ordinal];
    }

    public static Color get(char character) {
        for (Color color : Color.getAll()) {
            if (color.name().charAt(0) == character) {
                return color;
            }
        }
        return Color.NULL;
    }

    public static List<Color> getAll() {
        List<Color> colors = new ArrayList<>(Arrays.asList(Color.values()));
        colors.remove(Color.NULL);
        return colors;
    }

    public boolean isNull() {
        return this == Color.NULL;
    }

}
