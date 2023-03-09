package usantatecla.tictactoe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.utils.Console;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PlayerTest {

    @Mock
    private Console console;

    private final Color COLOR = Color.O;
    private PlayerBuilder playerBuilder;

    @BeforeEach
    public void BeforeEach() {
        this.playerBuilder = new PlayerBuilder().color(this.COLOR);
    }

    @Test
    public void testGivenNewPlayerWhenGetCoordinateThenReturnCorrectValue() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            Player player = this.playerBuilder.build();
            when(this.console.readInt(anyString())).thenReturn(2, 1);
            Coordinate coordinate = player.getCoordinate(Message.COORDINATE_TO_PUT);
            assertThat(coordinate, is(new Coordinate(1, 0)));
        }
    }

    @Test
    public void testGivenNewPlayerWhenGetCoordinateWithNullMessageThenAssertionError() {
        Player player = this.playerBuilder.build();
        Assertions.assertThrows(AssertionError.class, () -> player.getCoordinate(null));
    }


    @Test
    public void testGivenPlayerWhenPlayThenPutToken() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            Player player = this.playerBuilder.build();
            doReturn(new Coordinate(0, 0)).when(player).getCoordinate(any());
            player.play();
            verify(this.console, never()).writeln(any());
        }
    }

    @Test
    public void testGivenPlayerWhenPlayThenPutTokenError() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            Player player = this.playerBuilder.rows(
                    "X O",
                    "X O",
                    "   ").build();
            doReturn(new Coordinate(0, 2), new Coordinate(2, 2))
                    .when(player).getCoordinate(any());
            player.play();
            verify(this.console).writeln("The square is not empty");
        }
    }

    @Test
    public void testGivenPlayerWhenPlayThenMoveToken() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            Player player = this.playerBuilder.rows(
                "X O",
                "X O",
                "OX ").build();
            doReturn(new Coordinate(2, 0), new Coordinate(2, 2))
                    .when(player).getCoordinate(any());
            player.play();
            verify(this.console, never()).writeln(any());
        }
    }

    @Test
    public void testGivenPlayerWhenPlayThenMoveTokenNotOwnerError() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            Player player = this.playerBuilder.rows(
                "X O",
                "X O",
                "OX ").build();
            doReturn(new Coordinate(2, 1), new Coordinate(2, 0), new Coordinate(2, 2))
                    .when(player).getCoordinate(any());
            player.play();
            verify(this.console).writeln("There is not a token of yours");
        }
    }

    @Test
    public void testGivenPlayerWhenPlayThenMoveTokenNotEmptyError() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            Player player = this.playerBuilder.rows(
                "X O",
                "X O",
                "OX ").build();
            doReturn(new Coordinate(2, 0), new Coordinate(1, 2),
                    new Coordinate(2, 0), new Coordinate(2, 2))
                    .when(player).getCoordinate(any());
            player.play();
            verify(this.console).writeln("The square is not empty");
        }
    }

    @Test
    public void testGivenPlayerWhenPlayThenMoveTokenSameCoordinatesError() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            Player player = this.playerBuilder.rows(
                "X O",
                "X O",
                "OX ").build();
            doReturn(new Coordinate(2, 0), new Coordinate(2, 0), new Coordinate(2, 2))
                    .when(player).getCoordinate(any());
            player.play();
            verify(this.console).writeln("The origin and target squares are the same");
        }
    }

}
