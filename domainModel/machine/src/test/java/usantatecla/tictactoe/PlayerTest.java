package usantatecla.tictactoe;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import usantatecla.utils.Console;

@ExtendWith(MockitoExtension.class)
public abstract class PlayerTest {

    @Mock
    protected Console console;

    protected final Color COLOR = Color.O;

    public abstract PlayerBuilder getPlayerBuilder();

    @Test
    public void testGivenPlayerWhenGetPutTokenErrorThenErrorNULL() {
        Coordinate coordinate = new Coordinate(1, 1);
        Player player = this.getPlayerBuilder().build();
        assertThat(player.getPutTokenError(coordinate), is(Error.NULL));
    }

    @Test
    public void testGivenPlayerWhenGetPutTokenErrorThenErrorNotEmpty() {
        Player player = this.getPlayerBuilder().rows(
                "   ",
                " O ",
                "   "
        ).build();
        assertThat(player.getPutTokenError(new Coordinate(1, 1)), is(Error.NOT_EMPTY));
    }

    @Test
    public void testGivenPlayerWhenGetOriginMoveTokenErrorThenErrorNotOwner() {
        Player player = this.getPlayerBuilder().rows(
                "   ",
                " X ",
                "   "
        ).build();
        assertThat(player.getOriginMoveTokenError(new Coordinate(1, 1)), is(Error.NOT_OWNER));
    }

    @Test
    public void testGivenNewPlayerWhenGetOriginMoveTokenErrorThenReturnErrorNull() {
        Player player = this.getPlayerBuilder().rows(
                "OO ",
                "O  ",
                "   "
        ).build();
        assertThat(player.getOriginMoveTokenError(new Coordinate(0, 1)), is(Error.NULL));
    }

    @Test
    public void testGivenPlayerWhenGetTargetMoveTokenErrorThenNoError() {
        Player player = this.getPlayerBuilder().rows(
                "   ",
                " O ",
                "   "
        ).build();
        assertThat(player.getTargetMoveTokenError(new Coordinate(1, 1), new Coordinate(0, 0)), is(Error.NULL));
    }

    @Test
    public void testGivenPlayerWhenGetTargetMoveTokenErrorThenErrorNotEmpty() {
        Player player = this.getPlayerBuilder().rows(
                "   ",
                " OO",
                "   "
        ).build();
        assertThat(player.getTargetMoveTokenError(new Coordinate(1, 1), new Coordinate(1, 2)), is(Error.NOT_EMPTY));
    }

    @Test
    public void testGivenPlayerWhenGetTargetMoveTokenErrorThenErrorSameCoordinates() {
        Player player = this.getPlayerBuilder().rows(
                "   ",
                " O ",
                "   "
        ).build();
        assertThat(player.getTargetMoveTokenError(new Coordinate(1, 1), new Coordinate(1, 1)), is(Error.SAME_COORDINATES));
    }

    @Test
    public void testGivenPlayerWhenWriteWinnerThenPrint() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            Player player = this.getPlayerBuilder().build();
            player.writeWinner();
            verify(this.console).writeln(Color.O.toString() + " player: You win!!! :-)");
        }
    }

    @Test
    public void testGivenNewPlayerWhenGetColorThenReturnColor() {
        Player player = this.getPlayerBuilder().build();
        assertThat(player.getColor(), is(Color.O));
    }

}
