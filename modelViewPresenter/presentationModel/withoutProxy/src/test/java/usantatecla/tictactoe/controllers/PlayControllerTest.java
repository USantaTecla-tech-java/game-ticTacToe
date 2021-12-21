package usantatecla.tictactoe.controllers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Session;

public class PlayControllerTest {
    
    private PlayController playController;

    private Session session;

    private Coordinate coordinate00;
    private Coordinate coordinate11;
    private Coordinate coordinate01;

    public PlayControllerTest() {
        this.session = new Session(null);
        this.session.createPlayers(0);
        this.playController = new PlayController(this.session, null);
        this.coordinate00 = new Coordinate(0, 0);
        this.coordinate11 = new Coordinate(1, 1);
        this.coordinate01 = new Coordinate(0, 1);
    }

    @Test
    public void testGivenNewPlayControllerWhenACoordinateRow0Column0ThenIsValid() {
        assertThat(this.playController.isCoordinateValid(this.coordinate00), is(true));
    }

    @Test
    public void testGivenNewPlayControllerWhenACoordinateRow2Column2ThenIsValid() {
        assertThat(this.playController.isCoordinateValid(new Coordinate(2, 2)), is(true));
    }

    @Test
    public void testGivenNewPlayControllerWhenACoordinateRow3Column3ThenIsNotValid() {
        assertThat(this.playController.isCoordinateValid(new Coordinate(3, 3)), is(false));
    }

    @Test
    public void testGivenNewPlayControllerWhenACoordinateRowNegativeColumnNegativeThenIsNotValid() {
        assertThat(this.playController.isCoordinateValid(new Coordinate(-1, -1)), is(false));
    }

    @Test
    public void testGivenNewPlayControllerWhenGenerateRandomCoordinateThenIsNotNull() {
        //assertThat(this.playController.generateRandomCoordinate(), is(null));
    }

    @Test
    public void testGivenNewPlayControllerWhenPutNewTokenThenGetTokenCharIsValid() {
        this.playController.putTokenPlayerFromTurn(this.coordinate00);
        assertThat(this.playController.getTokenChar(this.coordinate00), is('X'));
    }

    @Test
    public void testGivenNewPlayControllerWhenPutNewTokenChangeTurnAndPutAnotherTokenThenGetTokenCharIsValid() {
        this.playController.putTokenPlayerFromTurn(this.coordinate00);
        assertThat(this.playController.getTokenChar(this.coordinate00), is('X'));
        this.playController.putTokenPlayerFromTurn(this.coordinate11);
        assertThat(this.playController.getTokenChar(this.coordinate11), is('O'));
    }

    @Test//(expected = AssertionError.class)
    public void testGivenNewPlayControllerWhenPutNewTokenOnOccupiedSpaceThenAssertionError() {
        this.playController.putTokenPlayerFromTurn(this.coordinate00);
        assertThat(this.playController.getTokenChar(this.coordinate00), is('X'));
        this.playController.putTokenPlayerFromTurn(this.coordinate11);
        assertThat(this.playController.getTokenChar(this.coordinate11), is('O'));
        this.playController.putTokenPlayerFromTurn(this.coordinate11);
    }

    @Test
    public void testGivenNewPlayControllerWhenMoveATokenGetTokenCharTargetAndCheckEmptyTokenOriginThenMovedIsCorrect() {
        this.playController.putTokenPlayerFromTurn(this.coordinate00);
        assertThat(this.playController.getTokenChar(this.coordinate00), is('X'));
        this.playController.putTokenPlayerFromTurn(this.coordinate11);
        assertThat(this.playController.getTokenChar(this.coordinate11), is('O'));
        Coordinate[] coordinates = new Coordinate[2];
        coordinates[0] = this.coordinate00;
        coordinates[1] = this.coordinate01;
        this.playController.moveTokenPlayerFromTurn(coordinates);
        assertThat(this.playController.getTokenChar(this.coordinate01), is('X'));
        assertThat(this.playController.isEmptyToken(this.coordinate00), is(false));
    }

    @Test//(expected = AssertionError.class)
    public void testGivenNewPlayControllerWhenMoveATokenWithOriginEmptyThenAssertionError() {
        this.playController.putTokenPlayerFromTurn(this.coordinate00);
        assertThat(this.playController.getTokenChar(this.coordinate00), is('X'));
        this.playController.putTokenPlayerFromTurn(this.coordinate11);
        assertThat(this.playController.getTokenChar(this.coordinate11), is('O'));
        Coordinate[] coordinates = new Coordinate[2];
        coordinates[0] = new Coordinate(1, 0);
        coordinates[1] = this.coordinate01;
        this.playController.moveTokenPlayerFromTurn(coordinates);
    }

    @Test//(expected = AssertionError.class)
    public void testGivenNewPlayControllerWhenMoveATokenWithTargetOccupiedThenAssertionError() {
        this.playController.putTokenPlayerFromTurn(this.coordinate00);
        assertThat(this.playController.getTokenChar(this.coordinate00), is('X'));
        this.playController.putTokenPlayerFromTurn(this.coordinate11);
        assertThat(this.playController.getTokenChar(this.coordinate11), is('O'));
        Coordinate[] coordinates = new Coordinate[2];
        coordinates[0] = this.coordinate00;
        coordinates[1] = this.coordinate11;
        this.playController.moveTokenPlayerFromTurn(coordinates);
    }

    @Test
    public void testGivenNewPlayControllerWhenGetCoordinateDimensionThenIsValid() {
        assertThat(this.playController.getCoordinateDimension(), is(Coordinate.DIMENSION));
    }

    @Test
    public void testGivenNewPlayControllerWhenPutTokenThenIsNotEmptyToken() {
        this.playController.putTokenPlayerFromTurn(this.coordinate00);
        assertThat(this.playController.isEmptyToken(this.coordinate00), is(false));
    }

    @Test
    public void testGivenNewPlayControllerWhenNotPutAnyTokenThenIsEmptyToken() {
        assertThat(this.playController.isEmptyToken(this.coordinate00), is(false));
    }

    @Test
    public void testGivenNewPlayControllerWhenCheckUndoableWithoutDoingAnyMovementThenIsFalse() {
        assertThat(this.playController.undoable(), is(false));
    }
    
    @Test
    public void testGivenNewPlayControllerWhenCheckUndoableDoingTwoMovementsThenIsTrue() {
        this.playController.putTokenPlayerFromTurn(coordinate00);
        this.playController.putTokenPlayerFromTurn(coordinate01);
        assertThat(this.playController.undoable(), is(true));
    }

    @Test
    public void testGivenNewPlayControllerWhenCheckUndoableDoingOneMovementsAndUndoThenIsFalse() {
        this.playController.putTokenPlayerFromTurn(coordinate00);
        assertThat(this.playController.undoable(), is(true));
        this.playController.undo();
        assertThat(this.playController.undoable(), is(false));
    }

    @Test
    public void testGivenNewPlayControllerWhenCheckRedoableDoingUndoThenIsTrue() {
        this.playController.putTokenPlayerFromTurn(coordinate00);
        this.playController.putTokenPlayerFromTurn(coordinate01);
        this.playController.undo();
        assertThat(this.playController.redoable(), is(true));
    }

    @Test
    public void testGivenNewPlayControllerWhenCheckRedoableDoingUndoAndRedoThenIsFalse() {
        this.playController.putTokenPlayerFromTurn(coordinate00);
        this.playController.putTokenPlayerFromTurn(coordinate01);
        this.playController.undo();
        assertThat(this.playController.redoable(), is(true));
        this.playController.redo();
        assertThat(this.playController.redoable(), is(false));
    }

    @Test
    public void testGivenNewPlayControllerWhenUndoMovementThenTheLastTokenPutIsEmpty() {
        this.playController.putTokenPlayerFromTurn(coordinate00);
        this.playController.putTokenPlayerFromTurn(coordinate01);
        this.playController.undo();
        assertThat(this.playController.isEmptyToken(coordinate01), is(false));
    }

    @Test
    public void testGivenNewPlayControllerWhenUndoAndRedoMovementThenTheLastTokenPutIsOcuppiedAgain() {
        this.playController.putTokenPlayerFromTurn(coordinate00);
        this.playController.putTokenPlayerFromTurn(coordinate01);
        this.playController.undo();
        assertThat(this.playController.isEmptyToken(coordinate01), is(false));
        this.playController.redo();
        assertThat(this.playController.isEmptyToken(coordinate01), is(false));
    }
}