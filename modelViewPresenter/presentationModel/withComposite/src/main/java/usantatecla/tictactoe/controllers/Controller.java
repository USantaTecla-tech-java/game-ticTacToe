package usantatecla.tictactoe.controllers;
import usantatecla.tictactoe.models.Session;
import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.types.Coordinate;

public abstract class Controller {

    protected Session session;

    Controller(Session session) {
        this.session= session;
    }

    public void nextState() {
        this.session.nextState();
    }

    public Color getColor(Coordinate coordinate) {
        return this.session.getColor(coordinate);
    }

}
