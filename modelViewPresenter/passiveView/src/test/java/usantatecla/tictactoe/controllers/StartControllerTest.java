package usantatecla.tictactoe.controllers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.models.GameBuilder;
import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.views.StartView;

@ExtendWith(MockitoExtension.class)
public class StartControllerTest extends ControllerTest {

    @Mock
    private StartView startView;

    @Override
    protected Controller getController(String... rows) {
        return new StartController(new GameBuilder().rows(rows).build(), this.viewFactory);
    }

    @Test
    public void testGivenStartControllerWhenControlThenCorrectInteractions() {
        when(this.viewFactory.createStartView()).thenReturn(this.startView);
        when(this.viewFactory.createBoardView()).thenReturn(this.boardView);
        this.controller = new StartController(new Game(), this.viewFactory);
        ((StartController) this.controller).control();
        verify(this.startView).write();
        String board =
                "   " +
                "   " +
                "   ";
        ArgumentCaptor<Color> argumentCaptor = ArgumentCaptor.forClass(Color.class);
        verify(this.boardView, atLeastOnce()).set(argumentCaptor.capture());
        assertThat(argumentCaptor.getAllValues(), is(this.stringToColors(board)));
        verify(this.boardView).write();
    }

}
