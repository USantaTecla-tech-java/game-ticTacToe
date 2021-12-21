package usantatecla.tictactoe.views.console;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.types.Coordinate;
import usantatecla.utils.views.Console;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BoardViewTest {

    @Mock
    private Console console;

    private BoardView boardView;
    private Conversor conversor;

    @BeforeEach
    public void beforeEach() {
        this.boardView = new BoardView();
        this.conversor = new Conversor();
    }

    @Test
    public void testGivenBoardViewWhenSetTooManyTimesThenAssertionError() {
        for(int i = 0; i < Coordinate.DIMENSION * Coordinate.DIMENSION; i++) {
            this.boardView.set(Color.NULL);
        }
        Assertions.assertThrows(AssertionError.class, () -> this.boardView.set(Color.NULL));
    }

    @Test
    public void testGivenBoardViewWhenWriteThenPrint() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.addColors(Arrays.asList(
                    Color.X, Color.NULL, Color.NULL,
                    Color.NULL, Color.O, Color.NULL,
                    Color.O, Color.NULL, Color.X
            ));
            this.boardView.write();
            String string = this.conversor.arrayToString(new String[]{
                    "---------------",
                    " | X |   |   | ",
                    " |   | O |   | ",
                    " | O |   | X | ",
                    "---------------"
            });
            ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
            verify(this.console, atLeast(0)).writeln(argumentCaptor.capture());
            verify(this.console, atLeast(0)).write(argumentCaptor.capture());
            List<String> argumentCaptorValues = argumentCaptor.getAllValues();
            this.conversor.reorder(argumentCaptorValues);
            assertThat(string, is(this.conversor.arrayToString(argumentCaptorValues.toArray())));
        }
    }

    private void addColors(List<Color> colors) {
        for (Color color : colors) {
            this.boardView.set(color);
        }
    }

}
