package usantatecla.tictactoe.models;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class StateTest {

    private State state;

    @BeforeEach
    public void beforeEach() {
        this.state = new State();
    }

    @Test
    public void testGivenNewStateWhenConstructThenStateValueIsINITIAL() {
        assertThat(this.state.getValueState(), is(StateValue.INITIAL));
    }

    @Test
    public void testGivenNewStateWhenResetThenStateValueIsINITIAL() {
        this.state.next();
        this.state.reset();
        assertThat(this.state.getValueState(), is(StateValue.INITIAL));
    }

    @Test
    public void testGivenNewStateWhenFourNextThenAssertionError2() {
           this.state.next();
            assertThat(this.state.getValueState(), is(StateValue.IN_GAME));
    }

    @Test
    public void testGivenNewStateWhenFourNextThenAssertionError4() {
           this.state.next();
           this.state.next();
           this.state.next();
            assertThat(this.state.getValueState(), is(StateValue.EXIT));
    }

    @Test
    public void testGivenNewStateWhenFourNextThenAssertionError() {
        this.state.next();
        this.state.next();
        this.state.next();
        assertThrows(AssertionError.class, () -> this.state.next());
    }

}
