package usantatecla.tictactoe.views.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.models.Session;
import usantatecla.tictactoe.types.Color;
import usantatecla.utils.views.Console;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PlayViewTest {

    @Mock
    private Console console;

    @Spy
    private Session session;

    private PlayController playController;
    private PlayView playView;


    @BeforeEach
    public void beforeEach(){
        this.playController = new PlayController(this.session);
        this.playView = new PlayView();
    }

    @Test
    public void testGivenPlayViewWhenInteractThenIsWinner() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readInt(anyString())).thenReturn(1);
            when(this.playController.getActiveColor()).thenReturn(Color.O);
            when(this.session.isTicTacToe()).thenReturn(true);
            this.playView.interact(this.playController);
            verify(this.console).writeln("O player: You win!!! :-)");
        }
    }

}
