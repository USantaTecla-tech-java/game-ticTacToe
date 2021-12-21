package usantatecla.tictactoe.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.models.GameBuilder;
import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.types.Coordinate;
import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.views.ErrorView;
import usantatecla.tictactoe.views.console.CoordinateView;
import usantatecla.tictactoe.views.console.PlayerView;

@ExtendWith(MockitoExtension.class)
public class PlayControllerTest extends ControllerTest {

    @Mock
    private PlayerView playerView;

    @Mock
    private CoordinateView coordinateView;

    @Mock
    private ErrorView errorView;

    private Game game;

    @Override
    protected Controller getController(String... rows) {
        this.game = spy(new GameBuilder().rows(rows).turn(Color.O).build());
        return new PlayController(this.game, this.viewFactory);
    }

    @Test
    public void testGivenPlayControllerWinnerGameWhenControlThenIsWinnerAndPutToken() {
        this.setUpMocks();
        this.controller = this.getController(
                "X O",
                "   ",
                "O X");
        Coordinate coordinate = new Coordinate(1,1);
        when(this.coordinateView.read(any())).thenReturn(coordinate);
        ((PlayController) this.controller).control();
        verify(this.game).putToken(coordinate);
        verify(this.playerView).writeWinner(Color.O);
    }

    private void setUpMocks() {
        when(this.viewFactory.createBoardView()).thenReturn(this.boardView);
        when(this.viewFactory.createPlayerView()).thenReturn(this.playerView);
        when(this.viewFactory.createCoordinateView()).thenReturn(this.coordinateView);
        when(this.viewFactory.createErrorView()).thenReturn(this.errorView);
    }

    @Test
    public void testGivenPlayControllerWhenControlThenMoveToken() {
        this.setUpMocks();
        this.controller = this.getController(
                "X O",
                "X O",
                "OX ");
        Coordinate origin = new Coordinate(2, 0);
        Coordinate target = new Coordinate(2, 2);
        when(this.coordinateView.read(any())).thenReturn(origin, target);
        ((PlayController) this.controller).control();
        verify(this.game).moveToken(origin, target);
    }

    @Test
    public void testGivenPlayControllerWhenControlThenPutTokenError() {
        this.setUpMocks();
        this.controller = this.getController(
                "X O",
                "X O",
                "   ");
        when(this.coordinateView.read(any())).thenReturn(new Coordinate(0, 0), new Coordinate(2, 2));
        ((PlayController) this.controller).control();
        verify(this.errorView).writeln(Error.NOT_EMPTY);
    }

    @Test
    public void testGivenPlayControllerWhenControlThenMoveTokenNotOwnerError() {
        this.setUpMocks();
        this.controller = this.getController(
                "X O",
                "X O",
                "OX ");
        when(this.coordinateView.read(any())).thenReturn(new Coordinate(2, 1), new Coordinate(2, 0), new Coordinate(2, 2));
        ((PlayController) this.controller).control();
        verify(this.errorView).writeln(Error.NOT_OWNER);
    }

    @Test
    public void testGivenPlayControllerWhenControlThenMoveTokenNotEmptyError() {
        this.setUpMocks();
        this.controller = this.getController(
                "X O",
                "X O",
                "OX ");
        when(this.coordinateView.read(any())).thenReturn(new Coordinate(2, 0), new Coordinate(2, 1),
                                                         new Coordinate(2, 0), new Coordinate(2, 2));
        ((PlayController) this.controller).control();
        verify(this.errorView).writeln(Error.NOT_EMPTY);
    }

    @Test
    public void testGivenPlayControllerWhenControlThenMoveTokenSameCoordinatesError() {
        this.setUpMocks();
        this.controller = this.getController(
                "X O",
                "X O",
                "OX ");
        when(this.coordinateView.read(any())).thenReturn(new Coordinate(2, 0), new Coordinate(2, 0), new Coordinate(2, 2));
        ((PlayController) this.controller).control();
        verify(this.errorView).writeln(Error.SAME_COORDINATES);
    }

}
