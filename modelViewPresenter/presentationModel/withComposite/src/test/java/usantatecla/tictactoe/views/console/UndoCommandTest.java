package usantatecla.tictactoe.views.console;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.views.Message;
import usantatecla.utils.models.Command;
import usantatecla.utils.models.CommandTest;

@ExtendWith(MockitoExtension.class)
public class UndoCommandTest extends CommandTest {

    @Mock
    private PlayController playController;

    @Override
    public Command getCommand() {
        return new UndoCommand(playController);
    }

    @Override
    public boolean isActive() {
        return this.getCommand().isActive();
    }

    @Override
    public String getTitle() {
        return Message.UNDO_COMMAND.toString();
    }

    @Test
    public void testGivenUndoCommandWhenExecuteThenAdd() {
        when(this.playController.getColor(any())).thenReturn(Color.X);
        this.getCommand().execute();
        verify(this.playController).undo();
    }
    
}
