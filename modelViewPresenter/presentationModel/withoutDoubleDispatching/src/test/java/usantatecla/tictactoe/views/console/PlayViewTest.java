package usantatecla.tictactoe.views.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.tictactoe.controllers.PlayController;
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
    private PlayController playController;

    private PlayView playView;

    @BeforeEach
    public void beforeEach(){
        this.playView = new PlayView();
    }

    @Test
    public void testGivenPlayViewWhenInteractThenIsWinner() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readInt(anyString())).thenReturn(1);
            when(this.playController.getColor(any(Coordinate.class))).thenReturn(Color.O);
            when(this.playController.getActiveColor()).thenReturn(Color.O);
            doReturn(true).when(this.playController).isTicTacToe();
            when(this.playController.getPutTokenError(any(Coordinate.class))).thenReturn(Error.NULL);
            this.playView.interact(this.playController);
            verify(this.playController).next();
            verify(this.console).writeln("O player: You win!!! :-)");
        }
    }

}
