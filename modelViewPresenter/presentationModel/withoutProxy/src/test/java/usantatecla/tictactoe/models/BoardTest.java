package usantatecla.tictactoe.models;

import org.junit.jupiter.api.Test;
import usantatecla.tictactoe.types.Token;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BoardTest {

    private Board board;

    public BoardTest() {
        this.board = new Board();
    }

    @Test
    public void testGivenNewBoardWhenPutNewTokenIsOccupiedThenIsTrue() {
        Token token = Token.values()[0];
        Coordinate coordinate = new Coordinate(0, 0);
        this.board.put(coordinate, token);
        assertThat(this.board.isOccupied(coordinate, token), is(true));
    }

    @Test
    public void testGivenNewBoardWhenPutNewTokenIsOccupiedThenIsFalse() {
        Token token = Token.values()[0];
        Coordinate coordinate = new Coordinate(0, 0);
        assertThat(this.board.isOccupied(coordinate, token), is(false));
    }

    @Test
    public void testGivenNewBoardWhenMoveNewTokenIsOccupiedAndOriginIsEmptyThenIsTrue() {
        Token token = Token.values()[0];
        Coordinate originCoordinate = new Coordinate(0, 0);
        Coordinate coordinateToMove = new Coordinate(0, 1);
        this.board.put(originCoordinate, token);
        this.board.move(originCoordinate, coordinateToMove);
        assertThat(this.board.isEmpty(originCoordinate), is(true));
        assertThat(this.board.isOccupied(coordinateToMove, token), is(true));
    }

    @Test
    public void testGivenNewBoardWhenMoveNewTokenIsOccupiedAndOriginIsEmptyThenIsFalse() {
        Token token = Token.values()[0];
        Coordinate originCoordinate = new Coordinate(0, 0);
        Coordinate coordinateToMove = new Coordinate(0, 1);
        this.board.put(originCoordinate, token);
        this.board.move(originCoordinate, coordinateToMove);
        assertThat(this.board.isEmpty(coordinateToMove), is(false));
        assertThat(this.board.isOccupied(originCoordinate, token), is(false));
    }

    @Test//(expected = AssertionError.class)
    public void testGivenNewBoardWhenMoveNewTokenTheOriginIsEmptyThenAssertionException() {
        Coordinate originCoordinate = new Coordinate(0, 0);
        Coordinate coordinateToMove = new Coordinate(0, 1);
        this.board.move(originCoordinate, coordinateToMove);
    }

    @Test
    public void testGivenNewBoardWhenPutThreeTokenAndIsTicTacToeThenIsTrue() {
        Token token = Token.values()[0];
        Coordinate coordinate11 = new Coordinate(0, 0);
        Coordinate coordinate12 = new Coordinate(0, 1);
        Coordinate coordinate13 = new Coordinate(0, 2);
        this.board.put(coordinate11, token);
        this.board.put(coordinate12, token);
        this.board.put(coordinate13, token);
        assertThat(this.board.isTicTacToe(token), is(true));
    }

    @Test
    public void testGivenNewBoardWhenPutTwoTokenAndIsTicTacToeThenIsFalse() {
        Token token = Token.values()[0];
        Coordinate coordinate11 = new Coordinate(0, 0);
        Coordinate coordinate12 = new Coordinate(0, 1);
        this.board.put(coordinate11, token);
        this.board.put(coordinate12, token);
        assertThat(this.board.isTicTacToe(token), is(false));
    }

    @Test
    public void testGivenNewBoardWhenNotPutTokensAndIsTicTacToeThenIsFalse() {
        Token token = Token.values()[0];
        assertThat(this.board.isTicTacToe(token), is(false));
    }

    @Test
    public void testGivenNewBoardWhenPutSixTokensAndIsCompletedThenIsTrue() {
        Token tokenX = Token.values()[0];
        Token tokenO = Token.values()[1];
        Coordinate coordinate11 = new Coordinate(0, 0);
        Coordinate coordinate21 = new Coordinate(1, 0);
        Coordinate coordinate12 = new Coordinate(0, 1);
        Coordinate coordinate22 = new Coordinate(1, 1);
        Coordinate coordinate23 = new Coordinate(1, 2);
        Coordinate coordinate33 = new Coordinate(2, 2);
        this.board.put(coordinate11, tokenX);
        this.board.put(coordinate21, tokenO);
        this.board.put(coordinate12, tokenX);
        this.board.put(coordinate22, tokenO);
        this.board.put(coordinate23, tokenX);
        this.board.put(coordinate33, tokenO);
        assertThat(this.board.isCompleted(), is(true));
    }

    @Test
    public void testGivenNewBoardWhenPutFiveTokensAndIsCompletedThenIsFalse() {
        Token tokenX = Token.values()[0];
        Token tokenO = Token.values()[1];
        Coordinate coordinate11 = new Coordinate(0, 0);
        Coordinate coordinate21 = new Coordinate(1, 0);
        Coordinate coordinate12 = new Coordinate(0, 1);
        Coordinate coordinate22 = new Coordinate(1, 1);
        Coordinate coordinate23 = new Coordinate(1, 2);
        this.board.put(coordinate11, tokenX);
        this.board.put(coordinate21, tokenO);
        this.board.put(coordinate12, tokenX);
        this.board.put(coordinate22, tokenO);
        this.board.put(coordinate23, tokenX);
        assertThat(this.board.isCompleted(), is(false));
    }

    @Test
    public void testGivenNewBoardWhenNotPutTokensAndIsCompletedThenIsFalse() {
        assertThat(this.board.isCompleted(), is(false));
    }
}
