package usantatecla.tictactoe.models;

import org.junit.jupiter.api.Test;
import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.types.Coordinate;
import usantatecla.tictactoe.types.Error;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public abstract class PlayerTest {

    protected final Color COLOR = Color.O;

    public abstract PlayerBuilder getPlayerBuilder();

    @Test
    public void testGivenPlayerWhenAreAllTokensOnBoardThenTrue() {
        Player player = this.getPlayerBuilder().rows(
                "OO ",
                "   ",
                " O "
        ).build();
        assertThat(player.areAllTokensOnBoard(), is(true));
    }

    @Test
    public void testGivenPlayerWhenAreAllTokensOnBoardThenFalse() {
        Player player = this.getPlayerBuilder().build();
        assertThat(player.areAllTokensOnBoard(), is(false));
    }

    @Test
    public void testGivenNewPlayerWhenAreAllTokensOnBoardThenReturnTrue() {
        Player player = this.getPlayerBuilder().rows(
                "OO ",
                "O  ",
                "   "
        ).build();
        assertThat(player.areAllTokensOnBoard(), is(true));
    }

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
    public void testGivenNewPlayerWhenGetColorThenReturnTheColor() {
        Player player = this.getPlayerBuilder().build();
        assertThat(player.getColor(), is(Color.O));
    }

}
