package usantatecla.tictactoe.models;

import org.junit.jupiter.api.Test;
import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.types.PlayerType;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MachinePlayerTest extends PlayerTest {

    @Override
    public PlayerBuilder getPlayerBuilder() {
        return new PlayerBuilder().color(Color.O).machine();
    }

    @Test
    public void testGivenNewPlayerWhenIsMachinePlayerThenReturnTrue() {
        Player player = this.getPlayerBuilder().build();
        assertThat(player.getType(), is(PlayerType.MACHINE));
    }

    @Test
    public void testGivenMachinePlayerWhenGetRandomCoordinateThenReturnValidCoordinate() {
        MachinePlayer player = (MachinePlayer) this.getPlayerBuilder().build();
        assertThat(player.getRandomCoordinate().isValid(), is(true));
    }


}
