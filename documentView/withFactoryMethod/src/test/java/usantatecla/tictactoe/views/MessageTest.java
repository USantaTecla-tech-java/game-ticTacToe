package usantatecla.tictactoe.views;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MessageTest {

    @Test
    public void testGivenNewMessageWhenToStringThenReturn() {
        assertThat(Message.COORDINATE_TO_PUT.toString(), is("Coordinate to put"));
    }
    
}
