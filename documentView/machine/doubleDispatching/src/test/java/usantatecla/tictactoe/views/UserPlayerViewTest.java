package usantatecla.tictactoe.views;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import usantatecla.tictactoe.models.PlayerBuilder;
import usantatecla.tictactoe.models.UserPlayer;
import usantatecla.tictactoe.types.Color;
import usantatecla.utils.views.Console;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

public class UserPlayerViewTest extends PlayerViewTest {

    @Mock
    private Console console;

    @BeforeEach
    public void beforeEach() {
        this.player = spy(new PlayerBuilder().color(Color.X).user().build());
        this.playerView = spy(new UserPlayerView((UserPlayer) this.player));
    }

    @Test
    public void testGivenUserPlayerViewWhenGetCoordinateThenReturn() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readInt(anyString())).thenReturn(
                    PlayerViewTest.ORIGIN.getRow() + 1,
                    PlayerViewTest.ORIGIN.getColumn() + 1
            );
            assertThat(this.playerView.getCoordinate(Message.COORDINATE_TO_PUT), is(PlayerViewTest.ORIGIN));
        }
    }

}
