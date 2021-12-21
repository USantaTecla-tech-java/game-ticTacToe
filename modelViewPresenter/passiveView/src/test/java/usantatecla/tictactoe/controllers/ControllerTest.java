package usantatecla.tictactoe.controllers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.views.ViewFactory;
import usantatecla.tictactoe.views.console.BoardView;

@ExtendWith(MockitoExtension.class)
public abstract class ControllerTest {

    @Mock
    protected BoardView boardView;

    @Mock
    protected ViewFactory viewFactory;

    protected Controller controller;

    @Test
    public void testGivenControllerWhenWriteBoardThenCorrectColorsCaptured() {
        when(this.viewFactory.createBoardView()).thenReturn(this.boardView);
        this.controller = this.getController(
                "X  ",
                " O ",
                "O X");
        this.controller.writeBoard();
        ArgumentCaptor<Color> argumentCaptor = ArgumentCaptor.forClass(Color.class);
        verify(this.boardView, atLeastOnce()).set(argumentCaptor.capture());
        String board =
                "X  " +
                " O " +
                "O X";
        assertThat(argumentCaptor.getAllValues(), is(this.stringToColors(board)));
        verify(this.boardView).write();
    }

    protected abstract Controller getController(String... rows);

    protected List<Color> stringToColors(String board) {
        List<Color> colors = new ArrayList<>();
        for (char character : board.toCharArray()) {
            colors.add(this.charToColor(character));
        }
        return colors;
    }

    private Color charToColor(char character) {
        switch (character) {
            case 'X':
                return Color.X;
            case 'O':
                return Color.O;
            default:
                return Color.NULL;
        }
    }

}
