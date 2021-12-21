package usantatecla.tictactoe.models;

import org.junit.jupiter.api.Test;
import usantatecla.tictactoe.types.PlayerType;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class UserPlayerTest extends PlayerTest {

    @Override
    public PlayerBuilder getPlayerBuilder() {
        return new PlayerBuilder().color(this.COLOR).user();
    }

    @Test
    public void testGivenNewPlayerWhenIsUserPlayerThenReturnTrue() {
        Player player = this.getPlayerBuilder().build();
        assertThat(player.getType(), is(PlayerType.USER));
    }

}
