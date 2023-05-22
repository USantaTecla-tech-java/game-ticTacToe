package usantatecla.tictactoe.distributed.dispatchers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.launchers.server.dispatchers.FrameType;
import usantatecla.tictactoe.launchers.server.dispatchers.TCPIP;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Session;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PutTokenDispatcherTest {

    ArgumentCaptor<String> tcpipArgumentCaptor = ArgumentCaptor.forClass(String.class);

    @Mock
    TCPIP tcpip;

    @InjectMocks
    PlayController playController = new PlayController(new Session(this.tcpip),this.tcpip);

    @Test
    public void testDispatch() {
        this.playController.putTokenPlayerFromTurn(new Coordinate(1,1));
        verify(this.tcpip).send(this.tcpipArgumentCaptor.capture());
        assertThat(this.tcpipArgumentCaptor.getAllValues().get(0),is(FrameType.PUT_TOKEN.name()));
    }
}
