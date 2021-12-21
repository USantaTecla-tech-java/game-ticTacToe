package usantatecla.tictactoe.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.models.GameBuilder;
import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.types.Coordinate;
import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.views.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PlayControllerTest {

    @Mock
    private BoardView boardView;

    @Mock
    private PlayerView playerView;

    @Mock
    private CoordinateView coordinateView;

    @Mock
    private ErrorView errorView;

    @Mock
    private ViewFactory viewFactory;

    private Game game;
    private PlayController playController;

    @Test
    public void testGivenPlayControllerWinnerGameWhenControlThenIsWinnerAndPutToken() {
        this.setUpMocks();
        this.game = spy(new GameBuilder().rows(
                "X O",
                "   ",
                "O X").turn(Color.O).build());
        this.playController = new PlayController(this.game, this.viewFactory);
        Coordinate coordinate = new Coordinate(1,1);
        when(this.coordinateView.read(any())).thenReturn(coordinate);
        this.playController.control();
        verify(this.game).putToken(coordinate);
        verify(this.playerView).writeWinner();
    }

    private void setUpMocks() {
        when(this.viewFactory.createBoardView(any())).thenReturn(this.boardView);
        when(this.viewFactory.createPlayerView(any())).thenReturn(this.playerView);
        when(this.viewFactory.createCoordinateView()).thenReturn(this.coordinateView);
        when(this.viewFactory.createErrorView()).thenReturn(this.errorView);
    }

    @Test
    public void testGivenPlayControllerWhenControlThenMoveToken() {
        this.setUpMocks();
        this.game = spy(new GameBuilder().rows(
            "X O",
            "X O",
            "OX ").turn(Color.O).build());
        this.playController = new PlayController(this.game, this.viewFactory);
        Coordinate origin = new Coordinate(2, 0);
        Coordinate target = new Coordinate(2, 2);
        when(this.coordinateView.read(any())).thenReturn(origin, target);
        this.playController.control();
        verify(this.game).moveToken(origin, target);
    }

    @Test
    public void testGivenPlayControllerWhenControlThenPutTokenError() {
        this.setUpMocks();
        this.game = new GameBuilder().rows(
                "X O",
                "X O",
                "   ").turn(Color.O).build();
        this.playController = new PlayController(this.game, this.viewFactory);
        when(this.coordinateView.read(any())).thenReturn(new Coordinate(0, 0), new Coordinate(2, 2));
        this.playController.control();
        verify(this.errorView).writeln(Error.NOT_EMPTY);
    }

    @Test
    public void testGivenPlayControllerWhenControlThenMoveTokenNotOwnerError() {
        this.setUpMocks();
        this.game = new GameBuilder().rows(
                "X O",
                "X O",
                "OX ").turn(Color.O).build();
        this.playController = new PlayController(this.game, this.viewFactory);
        when(this.coordinateView.read(any())).thenReturn(new Coordinate(2, 1), new Coordinate(2, 0),
                                                         new Coordinate(2, 2));
        this.playController.control();
        verify(this.errorView).writeln(Error.NOT_OWNER);
    }

    @Test
    public void testGivenPlayControllerWhenControlThenMoveTokenNotEmptyError() {
        this.setUpMocks();
        this.game = new GameBuilder().rows(
                "X O",
                "X O",
                "OX ").turn(Color.O).build();
        this.playController = new PlayController(this.game, this.viewFactory);
        when(this.coordinateView.read(any())).thenReturn(new Coordinate(2, 0), new Coordinate(2, 1),
                                                         new Coordinate(2, 0), new Coordinate(2, 2));
        this.playController.control();
        verify(this.errorView).writeln(Error.NOT_EMPTY);
    }

    @Test
    public void testGivenPlayControllerWhenControlThenMoveTokenSameCoordinatesError() {
        this.setUpMocks();
        this.game = new GameBuilder().rows(
                "X O",
                "X O",
                "OX ").turn(Color.O).build();
        this.playController = new PlayController(this.game, this.viewFactory);
        when(this.coordinateView.read(any())).thenReturn(new Coordinate(2, 0), new Coordinate(2, 0),
                                                         new Coordinate(2, 2));
        this.playController.control();
        verify(this.errorView).writeln(Error.SAME_COORDINATES);
    }

}
