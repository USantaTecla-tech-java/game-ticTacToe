package usantatecla.tictactoe.views.console;

import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import usantatecla.tictactoe.views.Message;
import usantatecla.utils.views.Console;

@ExtendWith(MockitoExtension.class)
public class MessageViewTest {

    @Mock
    private Console console;

    private MessageView messageView;

    @BeforeEach
    public void beforeEach() {
        this.messageView = new MessageView();
    }

    @Test
    public void testGivenNewMessageWhenWriteThenPrint() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.messageView.write(Message.COORDINATE_TO_PUT);
            verify(this.console).write("Coordinate to put");
        }
    }

    @Test
    public void testGivenNewMessageWhenWritelnThenPrint() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.messageView.writeln(Message.COORDINATE_TO_PUT);
            verify(this.console).writeln("Coordinate to put");
        }
    }

    @Test
    public void testGivenNewMessageWhenWritelnPlayerThenPrint() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            String player = "X";
            this.messageView.writeln(Message.PLAYER_WIN, player);
            verify(this.console).writeln(player + " player: You win!!! :-)");
        }
    }
    
}
