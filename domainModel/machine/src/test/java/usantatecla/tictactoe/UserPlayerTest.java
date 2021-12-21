package usantatecla.tictactoe;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.utils.Console;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserPlayerTest extends PlayerTest {

    @Override
    public PlayerBuilder getPlayerBuilder() {
        return new PlayerBuilder().color(this.COLOR).user();
    }

    @Test
    public void testGivenNewUserPlayerWhenGetCoordinateThenReturnCorrectValue() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readInt(anyString())).thenReturn(2, 1);
            Player player = this.getPlayerBuilder().build();
            assertThat(player.getCoordinate(Message.COORDINATE_TO_PUT), is(new Coordinate(1, 0)));
        }
    }

    @Test
    public void testGivenNewUserPlayerWhenGetCoordinateWithNullMessageThenAssertionError() {
        Player player = this.getPlayerBuilder().build();
        Assertions.assertThrows(AssertionError.class, () -> player.getCoordinate(null));
    }

    @Test
    public void testGivenNewUserPlayerWhenGetPutTokenErrorWithNullMessageThenAssertionError() {
        Player player = this.getPlayerBuilder().build();
        Assertions.assertThrows(AssertionError.class, () -> player.getPutTokenError(null));
    }

    @Test
    public void testGivenNewUserPlayerWhenGetOriginMoveTokenErrorWithNullMessageThenAssertionError() {
        Player player = this.getPlayerBuilder().build();
        Assertions.assertThrows(AssertionError.class, () -> player.getOriginMoveTokenError(new Coordinate()));
    }

    @Test
    public void testGivenNewUserPlayerWhenGetTargetMoveTokenErrorWithNullMessageThenAssertionError() {
        Player player = this.getPlayerBuilder().build();
        Assertions.assertThrows(AssertionError.class, () -> player.getTargetMoveTokenError(new Coordinate(), new Coordinate()));
    }

}
