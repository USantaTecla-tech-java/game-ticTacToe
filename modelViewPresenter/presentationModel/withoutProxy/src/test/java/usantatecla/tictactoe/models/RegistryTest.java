package usantatecla.tictactoe.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RegistryTest {

    @Captor
    private ArgumentCaptor<GameMemento> argumentCaptor;
    @Spy
    private Game game;
    private Registry registry;

    @BeforeEach
    void before() {
        this.game = spy(new GameBuilder().build());
        this.registry = new Registry(this.game);
    }

    @Test
    void testGivenNewGameRegistryWhenUndoThenIndexOutOfBoundsExceptionIsThrown() {
        assertThrows(IndexOutOfBoundsException.class, () -> this.registry.undo(this.game));
    }

    @Test
    void testGivenNewGameRegistryWhenRedoThenIndexOutOfBoundsExceptionIsThrown() {
        assertThrows(IndexOutOfBoundsException.class, () -> this.registry.redo(this.game));
    }

    @Test
    void testGivenNewGameRegistryWhenIsUndoableThenIsFalse() {
        assertThat(this.registry.undoable(), is(false));
    }

    @Test
    void testGivenNewGameRegistryWhenIsRedoableThenIsFalse() {
        assertThat(this.registry.redoable(), is(false));
    }

}
