package usantatecla.tictactoe.views.console;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.types.Coordinate;
import usantatecla.tictactoe.types.Error;
import usantatecla.utils.views.Console;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PlayViewTest {

    @Mock
    private Console console;

    @Mock
    private Logic logic;

    @InjectMocks
    private PlayView playView;

    @Test
    public void testGivenPlayViewWhenInteractThenIsWinner() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readInt(anyString())).thenReturn(1);
            when(this.logic.getColor(any(Coordinate.class))).thenReturn(Color.O);
            when(this.logic.getActiveColor()).thenReturn(Color.O);
            doReturn(true).when(this.logic).isTicTacToe();
            when(this.logic.getPutTokenError(any(Coordinate.class))).thenReturn(Error.NULL);
            this.playView.interact();
            verify(this.logic).next();
            verify(this.console).writeln("O player: You win!!! :-)");
        }
    }

}
