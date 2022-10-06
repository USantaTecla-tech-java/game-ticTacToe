package usantatecla.tictactoe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.MockedStatic;
import usantatecla.utils.Console;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

public class BoardTest {

    private BoardBuilder boardBuilder;

    @BeforeEach
    public void beforeEach() {
        this.boardBuilder = new BoardBuilder();
    }

    @Test
    public void testGivenEmptyBoardWhenStartThenIsEmpty() {
        Board board = this.boardBuilder.build();
        for (int i = 0; i < Coordinate.DIMENSION; i++) {
            for (int j = 0; j < Coordinate.DIMENSION; j++) {
                assertThat(board.isEmpty(new Coordinate(i, j)), is(true));
            }
        }
    }

    @Test
    public void testGivenNewBoardWhenPutNewTokenThenIsOccupiedIsTrue() {
        Board board = this.boardBuilder.build();
        Color color = Color.O;
        Coordinate coordinate = new Coordinate(0, 0);
        board.putToken(coordinate, color);
        assertThat(board.isOccupied(coordinate, color), is(true));
    }

    @Test
    public void testGivenBoardWhenMoveXTokenOriginIsEmptyAndTargetIsOccupiedThenIsTrue() {
        Board board = this.boardBuilder.rows(
                "X  ",
                "   ",
                "   ").build();
        Coordinate origin = new Coordinate(0, 0);
        Coordinate target = new Coordinate(0, 1);
        board.moveToken(origin, target);
        assertThat(board.isEmpty(origin), is(true));
        assertThat(board.isOccupied(target, Color.X), is(true));
    }

    @Test
    public void testGivenBoardWhenMoveXTokenAndTargetIsOccupiedThenIsAssertion() {
        Board board = this.boardBuilder.rows(
                "XO ",
                "   ",
                "   ").build();
        Coordinate origin = new Coordinate(0, 0);
        Coordinate target = new Coordinate(0, 1);
        Assertions.assertThrows(AssertionError.class, () -> board.moveToken(origin, target));
    }

    @Test
    public void testGivenBoardWhenMoveTokenAndOriginIsEmptyThenIsAssertion() {
        Board board = this.boardBuilder.build();
        Coordinate origin = new Coordinate(1, 0);
        Coordinate target = new Coordinate(2, 2);
        Assertions.assertThrows(AssertionError.class, () -> board.moveToken(origin, target));
    }

    @Test
    public void testGivenBoardWhenMoveTokenAndOriginIsEqualsTargetThenIsAssertion() {
        Board board = this.boardBuilder.rows(
                "X  ",
                "   ",
                "   ").build();
        Coordinate origin = new Coordinate(0, 0);
        Coordinate target = new Coordinate(0, 0);
        Assertions.assertThrows(AssertionError.class, () -> board.moveToken(origin, target));
    }

    @Test
    public void testGivenEmptyBoardWhenCheckIsOccupiedThenIsFalse() {
        Board board = this.boardBuilder.build();
        assertThat(board.isOccupied(new Coordinate(0, 0), Color.X), is(false));
    }

    @Test
    public void testGivenBoardWhenCheckIsOccupiedThenIsTrue() {
        Board board = this.boardBuilder.rows(
                "X  ",
                "   ",
                "   ").build();
        assertThat(board.isOccupied(new Coordinate(0, 0), Color.X), is(true));
    }

    @Test
    public void testGivenBoardWhenCheckNullCoordinateIsOccupiedThenAssertionError() {
        Board board = this.boardBuilder.build();
        Assertions.assertThrows(AssertionError.class, () -> board.isOccupied(new Coordinate(), Color.O));
    }

    @Test
    public void testGivenBoardWhenIsTicTacToeThenIsFalse() {
        Board board = this.boardBuilder.build();
        assertThat(board.isTicTacToe(Color.O), is(false));
    }

    @Test
    public void testGivenBoardWhenIsTicTacToeNullColorThenAssertionError() {
        Board board = this.boardBuilder.build();
        Assertions.assertThrows(AssertionError.class, () -> board.isTicTacToe(Color.NULL));
    }

    @Test
    public void testGivenBoardWhenIsVerticalTicTacToeThenIsTrue() {
        Board board = this.boardBuilder.rows(
                " X ",
                "OXO",
                " X ").build();
        assertThat(board.isTicTacToe(Color.X), is(true));
    }

    @Test
    public void testGivenBoardWhenIsHorizontalTicTacToeThenIsTrue() {
        Board board = this.boardBuilder.rows(
                " O ",
                "XXX",
                " O ").build();
        assertThat(board.isTicTacToe(Color.X), is(true));
    }

    @Test
    public void testGivenBoardWhenIsDiagonalTicTacToeThenIsTrue() {
        Board board = this.boardBuilder.rows(
                "X  ",
                "OXO",
                "  X").build();
        assertThat(board.isTicTacToe(Color.X), is(true));
    }

    @Test
    public void testGivenBoardWhenIsInverseDiagonalTicTacToeThenIsTrue() {
        Board board = this.boardBuilder.rows(
                "  X",
                "OXO",
                "X  ").build();
        assertThat(board.isTicTacToe(Color.X), is(true));
    }

    @Test
    public void testGivenCompleteBoardAndIsTicTacToeThenIsFalse() {
        Board board = this.boardBuilder.rows(
                "XO ",
                "XO ",
                "OX ").build();
        assertThat(board.isTicTacToe(Color.X), is(false));
        assertThat(board.isTicTacToe(Color.O), is(false));
    }

    @Test
    public void testGivenEmptyBoardWhenWriteThenPrint() {
        Console console = mock(Console.class);
        try (MockedStatic<Console> staticConsole = mockStatic(Console.class)) {
            staticConsole.when(Console::getInstance).thenReturn(console);
            Board board = this.boardBuilder.build();
            board.write();
            String string = this.arrayToString(new String[] {
                    "---------------",
                    " |   |   |   | ",
                    " |   |   |   | ",
                    " |   |   |   | ",
                    "---------------",
            });
            ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
            verify(console,atLeast(0)).writeln(argumentCaptor.capture());
            verify(console,atLeast(0)).write(argumentCaptor.capture());
            List<String> argumentCaptorValues = argumentCaptor.getAllValues();
            this.reorder(argumentCaptorValues);
            assertThat(string,is(arrayToString(argumentCaptorValues.toArray())));
        }
    }

    @Test
    public void testGivenCompleteBoardWhenWriteThenPrint() {
        Console console = mock(Console.class);
        try (MockedStatic<Console> staticConsole = mockStatic(Console.class)) {
            staticConsole.when(Console::getInstance).thenReturn(console);
            Board board = this.boardBuilder.rows(
                    "X X",
                    "XO ",
                    "O O").build();
            board.write();
            String string = this.arrayToString(new String[] {
                    "---------------",
                    " | X |   | X | ",
                    " | X | O |   | ",
                    " | O |   | O | ",
                    "---------------"
            });
            ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
            verify(console,atLeast(0)).writeln(argumentCaptor.capture());
            verify(console,atLeast(0)).write(argumentCaptor.capture());
            List<String> argumentCaptorValues = argumentCaptor.getAllValues();
            this.reorder(argumentCaptorValues);
            assertThat(string,is(this.arrayToString(argumentCaptorValues.toArray())));
        }
    }

    private String arrayToString(Object[] objects) {
        String string = "";
        for (Object object : objects) {
            string += object;
        }
        return string;
    }

    private void reorder(List<String> list){
        list.add(list.size()-1, list.remove(1));
    }

}
