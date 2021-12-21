package usantatecla.tictactoe.views;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.types.Coordinate;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public abstract class PlayerViewTest {

    final static Coordinate ORIGIN = new Coordinate(0, 0);
    final static Coordinate TARGET = new Coordinate(0, 1);

    @Spy
    protected Game game;

    protected PlayerView playerView;

    @Test
    public void testGivenPlayerViewWhenInteractThenPutToken() {
        doReturn(PlayerViewTest.ORIGIN).when(playerView).getCoordinate(any());
        this.playerView.interact(this.game);
        verify(this.game).putToken(PlayerViewTest.ORIGIN);
    }

    @Test
    public void testGivenPlayerViewWhenInteractThenMoveToken() {
        doReturn(true).when(this.game).areAllTokensOnBoard();
        doReturn(PlayerViewTest.ORIGIN, PlayerViewTest.TARGET).when(playerView).getCoordinate(any());
        this.game.putToken(PlayerViewTest.ORIGIN);
        this.playerView.interact(this.game);
        verify(this.game).moveToken(PlayerViewTest.ORIGIN, PlayerViewTest.TARGET);
    }

}
