package usantatecla.tictactoe.models;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usantatecla.tictactoe.types.Color;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MementoTest {

    private Memento memento;
    private Board board;
    private Turn turn;

    @BeforeEach
    public void beforeEach() {
        this.board = new BoardBuilder().rows(
            "X  ",
            "O X",
            "   "
        ).build();
        this.turn = new Turn(this.board);
        this.memento = new Memento(this.board, this.turn);
    }

    @Test
    public void testGivenMementoWhereGetBoardThenReturn() {
        assertThat(this.memento.getBoard().toCharacterArray(), is(this.board.toCharacterArray()));
    }

    @Test
    public void testGivenMementoWhenGetActivePlayerThenReturn() {
        assertThat(this.memento.getActivePlayer(), is(0));
    }

    @Test
    public void testGivenMementoWhenGetPlayerPutTokensThenReturn() {
        assertThat(this.memento.getPlayerPutTokens(Color.X), is(2));
        assertThat(this.memento.getPlayerPutTokens(Color.O), is(1));
    }

}
