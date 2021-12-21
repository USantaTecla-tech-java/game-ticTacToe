package usantatecla.tictactoe.types;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ColorTest {

    @Test
    public void testGivenNewColorWhenGetThenReturn() {
        assertThat(Color.get(0), is(Color.X));
        assertThat(Color.get(1), is(Color.O));
    }

    @Test
    public void testGivenNewColorWhenGetThenAssertionError() {
        assertThrows(AssertionError.class, () -> Color.get(2));
        assertThrows(AssertionError.class, () -> Color.get(-1));
    }

    @Test
    public void testGivenColorWhenIsNullThenFalse() {
        assertThat(Color.X.isNull(), is(false));
        assertThat(Color.O.isNull(), is(false));
    }

    @Test
    public void testGivenColorWhenIsNullThenTrue() {
        assertThat(Color.NULL.isNull(), is(true));
    }
    
}
