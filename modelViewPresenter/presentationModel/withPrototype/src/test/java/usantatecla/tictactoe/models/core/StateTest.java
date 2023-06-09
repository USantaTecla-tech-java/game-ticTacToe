package usantatecla.tictactoe.models.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import usantatecla.tictactoe.models.types.StateValue;

public class StateTest {
    
    private State state;

    public StateTest() {
        this.state = new State();
    }

    @Test
    public void testGivenNewStateWhenGetValueStateThenIsInitial() {
        assertEquals(StateValue.INITIAL, this.state.getValueState());
    }

    @Test
    public void testGivenNewStateWhenDoNextAndGetValueStateThenIsInGame() {
        this.state.next();
        assertEquals(StateValue.IN_GAME, this.state.getValueState());
    }

    @Test
    public void testGivenNewStateWhenDoTwoNextAndGetValueStateThenIsSave() {
        this.state.next();
        this.state.next();
        assertEquals(StateValue.SAVING, this.state.getValueState());
    }

    @Test
    public void testGivenNewStateWhenDoTwoNextAndGetValueStateThenIsResult() {
        this.state.next();
        this.state.next();
        this.state.next();
        assertEquals(StateValue.RESUME, this.state.getValueState());
    }

    @Test
    public void testGivenNewStateWhenDoThreeNextAndGetValueStateThenIsExit() {
        this.state.next();
        this.state.next();
        this.state.next();
        this.state.next();
        assertEquals(StateValue.EXIT, this.state.getValueState());
    }
}