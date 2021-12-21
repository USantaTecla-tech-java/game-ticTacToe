package usantatecla.tictactoe.views;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

public class MessageTest {

    @Test
    public void testGivenNewMessageWhenToStringThenReturn() {
        assertThat(Message.COORDINATE_TO_PUT.toString(), is("Coordinate to put"));
    }
    
}
