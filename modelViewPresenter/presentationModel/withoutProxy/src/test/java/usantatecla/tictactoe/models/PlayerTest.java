package usantatecla.tictactoe.models;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;
import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.types.PlayerType;
import usantatecla.tictactoe.types.Token;

public class PlayerTest {
    
    private Board board;

    private Player player;

    private Coordinate coordinate00;
    private Coordinate coordinate01;

    public PlayerTest() {
        this.board = new Board();
        this.player = new Player(Token.O, this.board, PlayerType.USER_PLAYER);
        this.coordinate00 = new Coordinate(0, 0);
        this.coordinate01 = new Coordinate(0, 1);
    }

    @Test
    public void testGivenNewPlayerWhenPutNewTokenThenReturnErrorNull() {
        this.board.put(this.coordinate00, Token.O);
        assertThat(this.player.put(this.coordinate01) == Error.NULL, is(true));
    }

    @Test
    public void testGivenNewPlayerWhenRemoveTokenThenNotReturnErrorNull() {
        this.board.put(this.coordinate00, Token.O);
        assertThat(this.player.put(this.coordinate00) == Error.NULL, is(false));
    }

    @Test
    public void testGivenNewPlayerWhenMoveTokenThenReturnErrorSameCoordinates() {
        this.board.put(this.coordinate00, Token.O);
        assertThat(this.player.move(this.coordinate00, this.coordinate00), is(Error.SAME_COORDINATES));
    }

    @Test
    public void testGivenNewPlayerWhenMoveTokenThenReturnErrorNotEmpty() {
        this.board.put(this.coordinate00, Token.O);
        this.board.put(this.coordinate01, Token.O);
        assertThat(this.player.move(this.coordinate00, this.coordinate01), is(Error.NOT_EMPTY));
    }

    @Test
    public void testGivenNewPlayerWhenMoveTokenThenNotReturnErrorNull() {
        this.board.put(this.coordinate00, Token.O);
        assertThat(this.player.move(this.coordinate00, this.coordinate01) == Error.NULL, is(true));
    }
}