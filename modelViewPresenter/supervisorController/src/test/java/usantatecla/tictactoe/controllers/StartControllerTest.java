package usantatecla.tictactoe.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.views.BoardView;
import usantatecla.tictactoe.views.StartView;
import usantatecla.tictactoe.views.ViewFactory;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StartControllerTest {

    @Mock
    private StartView startView;

    @Mock
    private BoardView boardView;

    @Mock
    private ViewFactory viewFactory;

    private StartController startController;

    @BeforeEach
    public void beforeEach() {
        this.startController = new StartController(new Game(), this.viewFactory);
    }

    @Test
    public void testGivenStartControllerWhenControlThenCorrectInteractions() {
        when(this.viewFactory.createStartView()).thenReturn(this.startView);
        when(this.viewFactory.createBoardView(any())).thenReturn(this.boardView);
        this.startController.control();
        verify(this.startView).write();
        verify(this.boardView).write();
    }

}
