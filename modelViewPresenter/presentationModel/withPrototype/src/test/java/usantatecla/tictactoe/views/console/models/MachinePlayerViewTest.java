package usantatecla.tictactoe.views.console.models;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import usantatecla.tictactoe.controllers.implementation.PlayControllerImplementation;
import usantatecla.tictactoe.models.core.Coordinate;
import usantatecla.tictactoe.models.core.Session;
import usantatecla.tictactoe.models.core.SessionImplementation;

public class MachinePlayerViewTest {

    private Session session;

    private MachinePlayerView machinePlayerView;

    public MachinePlayerViewTest() {
        this.session = new SessionImplementation();
        ((SessionImplementation) this.session).createPlayers(0);
        this.machinePlayerView = new MachinePlayerView(new PlayControllerImplementation(this.session));
    }

    @Test
    public void testGivenNewCoordinateViewWhenReadCoordinateThenIsCorrect() {
        Coordinate coordinate = this.machinePlayerView.readCoordinateToPut();
        assertNotNull(coordinate);
    }

    @Test
    public void testGivenNewCoordinateViewWhenReadCoordinateThenIsCorrec() {
        Coordinate coordinate1 = this.machinePlayerView.readCoordinateToPut();
        ((SessionImplementation) this.session).putTokenPlayerFromTurn(coordinate1);
        Coordinate coordinate2 = this.machinePlayerView.readCoordinateToPut();
        ((SessionImplementation) this.session).putTokenPlayerFromTurn(coordinate2);
        Coordinate[] coordinates = this.machinePlayerView.readCoordinatesToMove();
        assertNotNull(coordinates[0]);
        assertNotNull(coordinates[1]);
    }
    
}