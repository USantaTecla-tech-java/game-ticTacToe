package usantatecla.tictactoe;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

public class MachinePlayerTest extends PlayerTest {

    @Override
    public PlayerBuilder getPlayerBuilder() {
        return new PlayerBuilder().color(Color.O).machine();
    }

    @Test
    public void testGivenMachinePlayerWhenGetRandomCoordinateThenReturnValidCoordinate() {
        MachinePlayer player = (MachinePlayer) this.getPlayerBuilder().build();
        assertThat(player.getCoordinate(Message.COORDINATE_TO_PUT).isValid(), is(true));
    }

}
