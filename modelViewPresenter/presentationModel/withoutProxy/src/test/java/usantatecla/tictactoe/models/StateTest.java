package usantatecla.tictactoe.models;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

public class StateTest {
    
    private State state;

    public StateTest() {
        this.state = new State();
    }

    @Test
    public void testGivenNewStateWhenGetValueStateThenIsInitial() {
        assertThat(this.state.getValueState(), is(StateValue.INITIAL));
    }

    @Test
    public void testGivenNewStateWhenDoNextAndGetValueStateThenIsInGame() {
        this.state.next();
        assertThat(this.state.getValueState(), is(StateValue.IN_GAME));
    }

    @Test
    public void testGivenNewStateWhenDoTwoNextAndGetValueStateThenIsResult() {
        this.state.next();
        this.state.next();
        assertThat(this.state.getValueState(), is(StateValue.RESUME));
    }

    @Test
    public void testGivenNewStateWhenDoThreeNextAndGetValueStateThenIsExit() {
        this.state.next();
        this.state.next();
        this.state.next();
        assertThat(this.state.getValueState(), is(StateValue.EXIT));
    }
}