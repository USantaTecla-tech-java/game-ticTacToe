package usantatecla.tictactoe.views.console.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import usantatecla.tictactoe.controllers.implementation.PlayControllerImplementation;
import usantatecla.tictactoe.models.core.Coordinate;
import usantatecla.tictactoe.models.core.SessionImplementation;
import usantatecla.utils.Console;

@ExtendWith(MockitoExtension.class)
public class CoordinateViewTest {
    static final String ENTER_COORDINATE_TO_PUT = "Enter a coordinate to put a token:";

    @Mock
    Console console;

    @InjectMocks
    CoordinateView coordinateView = new CoordinateView(new PlayControllerImplementation(new SessionImplementation()));

    @Test
    public void testGivenNewCoordinateViewWhenReadCoordinateThenIsCorrect() {
        when(this.console.readInt("Row: ")).thenReturn(1);
        when(this.console.readInt("Column: ")).thenReturn(1);
        Coordinate coordinateRead = this.coordinateView.read(ENTER_COORDINATE_TO_PUT);
        Coordinate coordinateExpected = new Coordinate(0, 0);
        assertEquals(coordinateExpected.getRow(), coordinateRead.getRow());
        assertEquals(coordinateExpected.getColumn(), coordinateRead.getColumn());
    }

    @Test
    public void testGivenNewCoordinatesWhenRow4AndColumn4ThenAssertionException() {
        when(this.console.readInt("Row: ")).thenReturn(4);
        when(this.console.readInt("Column: ")).thenReturn(4);
        Assertions.assertThrows(AssertionError.class, () ->
            this.coordinateView.read("Title"));
        verify(this.console).readInt("Row: ");
        verify(this.console).readInt("Column: ");
    }

    @Test
    public void testGivenNewCoordinatesWhenRow0AndColumn0ThenAssertionException() {
        when(this.console.readInt("Row: ")).thenReturn(0);
        when(this.console.readInt("Column: ")).thenReturn(0);
        Assertions.assertThrows(AssertionError.class, () ->
            this.coordinateView.read("Title"));
        verify(this.console).readInt("Row: ");
        verify(this.console).readInt("Column: ");
    }

    @Test
    public void testGivenNewCoordinatesWhenRow1AndColumn1ThenIsCorrect() {
        when(this.console.readInt("Row: ")).thenReturn(1);
        when(this.console.readInt("Column: ")).thenReturn(1);
        this.coordinateView.read("Title");
        verify(this.console).readInt("Row: ");
        verify(this.console).readInt("Column: ");
    }

    @Test
    public void testGivenNewCoordinatesWhenRow3AndColumn3ThenIsCorrect() {
        when(this.console.readInt("Row: ")).thenReturn(3);
        when(this.console.readInt("Column: ")).thenReturn(3);
        this.coordinateView.read("Title");
        verify(this.console).readInt("Row: ");
        verify(this.console).readInt("Column: ");
    }
}