package usantatecla.tictactoe.views.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.tictactoe.models.PlayerBuilder;
import usantatecla.tictactoe.types.Color;
import usantatecla.utils.views.Console;

import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class PlayerViewTest {

    @Mock
    private Console console;

    private PlayerView playerView;

    @BeforeEach
    public void beforeEach() {
        this.playerView = new PlayerView(new PlayerBuilder().color(Color.X).build());
    }

    @Test
    public void testGivenPlayerViewWhenWriteWinnerThenPrint() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.playerView.writeWinner();
            verify(this.console).writeln("X player: You win!!! :-)");
        }
    }

}
