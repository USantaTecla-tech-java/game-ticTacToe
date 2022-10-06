package usantatecla.tictactoe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.utils.Console;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TurnTest {

    @Mock
    private Console console;

    private Turn turn;

    @BeforeEach
    public void beforeEach() {
        this.turn = new Turn(new Board());
    }

    @Test
    public void testGivenNewTurnWhenNullBoardThenAssertionError() {
        Assertions.assertThrows(AssertionError.class, () -> this.turn = new Turn(null));
    }

    @Test
    public void testGivenNewTurnWhenWriteWinnerThenCorrectMessage() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.turn.writeWinner();
            verify(this.console).writeln("X player: You win!!! :-)");
        }
    }

    @Test
    public void testGivenNewTurnWhenGetActiveColorThenCorrectColorIsCaptured() {
        assertThat(this.turn.getActiveColor(), is(Color.X));
    }

    @Test
    public void testGivenTurnWhenPlayAndGetActiveColorThenCorrectColorIsCaptured() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readInt(anyString())).thenReturn(1);
            this.turn.play();
            assertThat(this.turn.getActiveColor(), is(Color.O));
        }

    }

}
