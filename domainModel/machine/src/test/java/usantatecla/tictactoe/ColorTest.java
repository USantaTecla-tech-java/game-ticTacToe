package usantatecla.tictactoe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.utils.Console;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ColorTest {

    @Mock
    Console console;

    @Test
    public void testGivenNewColorWhenGetThenReturn() {
        assertThat(Color.get(0), is(Color.X));
        assertThat(Color.get(1), is(Color.O));
    }

    @Test
    public void testGivenNewColorWhenGetThenAssertionError() {
        Assertions.assertThrows(AssertionError.class, () -> Color.get(Color.NULL.ordinal()));
        Assertions.assertThrows(AssertionError.class, () -> Color.get(-1));
    }

    @Test
    public void testGivenColorWhenWriteThenPrint() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            Color.X.write();
            verify(this.console).write("X");
            Color.O.write();
            verify(this.console).write("O");
            Color.NULL.write();
            verify(this.console).write(" ");
        }
    }

    @Test
    public void testGivenColorWhenIsNullThenValue() {
        assertThat(Color.X.isNull(), is(false));
        assertThat(Color.O.isNull(), is(false));
        assertThat(Color.NULL.isNull(), is(true));
    }
}
