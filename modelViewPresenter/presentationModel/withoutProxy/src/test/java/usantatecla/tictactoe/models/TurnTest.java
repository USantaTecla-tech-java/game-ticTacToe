package usantatecla.tictactoe.models;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;
import usantatecla.tictactoe.types.PlayerType;
import usantatecla.tictactoe.types.Token;

public class TurnTest {

    private Turn turn;
    private Player[] players;

    public TurnTest() {
        Board board = new Board();
        this.players = new Player[2];
        this.players[0] = new Player(Token.values()[0], board, PlayerType.USER_PLAYER);
        this.players[1] = new Player(Token.values()[1], board, PlayerType.MACHINE_PLAYER);
        this.turn = new Turn(this.players);
    }

    @Test
    public void testGivenNewTurnWhenChangeTurnThenIsOtherTurn() {
        assertThat(this.turn.getPlayer().getToken(), is(this.players[0].getToken()));
        assertThat(this.turn.getOtherPlayer().getToken(), is(this.players[1].getToken()));
        this.turn.change();
        assertThat(this.turn.getPlayer().getToken(), is(this.players[1].getToken()));
        assertThat(this.turn.getOtherPlayer().getToken(), is(this.players[0].getToken()));
    }

    @Test
    public void testGivenNewTurnWhenChangeTurnTwoTimesThenIsTheSameTurn() {
        assertThat(this.turn.getPlayer().getToken(), is(this.players[0].getToken()));
        assertThat(this.turn.getOtherPlayer().getToken(), is(this.players[1].getToken()));
        this.turn.change();
        assertThat(this.turn.getPlayer().getToken(), is(this.players[1].getToken()));
        assertThat(this.turn.getOtherPlayer().getToken(), is(this.players[0].getToken()));
        this.turn.change();
        assertThat(this.turn.getPlayer().getToken(), is(this.players[0].getToken()));
        assertThat(this.turn.getOtherPlayer().getToken(), is(this.players[1].getToken()));
    }
}