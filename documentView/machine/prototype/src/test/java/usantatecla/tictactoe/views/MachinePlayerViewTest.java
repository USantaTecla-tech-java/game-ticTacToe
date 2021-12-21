package usantatecla.tictactoe.views;

import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.spy;

public class MachinePlayerViewTest extends PlayerViewTest {

    @BeforeEach
    public void beforeEach() {
        this.playerView = spy(new MachinePlayerView());
        this.game.setUsers(1);
    }

}
