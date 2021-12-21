package usantatecla.tictactoe.views;

import org.junit.jupiter.api.BeforeEach;
import usantatecla.tictactoe.models.MachinePlayer;
import usantatecla.tictactoe.models.PlayerBuilder;
import usantatecla.tictactoe.types.Color;

import static org.mockito.Mockito.spy;

public class MachinePlayerViewTest extends PlayerViewTest {

    @BeforeEach
    public void beforeEach() {
        this.player = spy(new PlayerBuilder().color(Color.X).machine().build());
        this.playerView = spy(new MachinePlayerView((MachinePlayer) this.player));
    }

}
