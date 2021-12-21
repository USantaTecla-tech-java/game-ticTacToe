package usantatecla.tictactoe;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import usantatecla.utils.Console;

@ExtendWith(MockitoExtension.class)
public class ErrorTest {

    @Mock
    private Console console;

    @Test
    public void testGivenCorrectErrorWhenWritelnThenPrint() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            Error.NOT_OWNER.writeln();
            verify(this.console).writeln("There is not a token of yours");
        }
    }

    @Test
    public void testGivenNullErrorWhenWritelnThenConsoleIsNotCalled() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            Error.NULL.writeln();
            verify(this.console, never()).writeln(anyString());
        }
    }

    @Test
    public void testGivenNullErrorWhenIsNullThenTrue() {
        assertThat(Error.NULL.isNull(), is(true));
    }

    @Test
    public void testGivenNotNullErrorWhenIsNullThenFalse() {
        assertThat(Error.NOT_OWNER.isNull(), is(false));
    }

}
