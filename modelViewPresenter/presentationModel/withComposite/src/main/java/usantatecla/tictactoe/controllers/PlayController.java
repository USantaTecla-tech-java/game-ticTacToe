package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Session;
import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.types.Coordinate;
import usantatecla.tictactoe.types.Error;

public class PlayController extends Controller implements AcceptorController {
    private ActionController actionController;
    private UndoController undoController;
    private RedoController redoController;

    public PlayController(Session session) {
        super(session);
        this.actionController = new ActionController(session);
        this.undoController = new UndoController(session);
        this.redoController = new RedoController(session);
    }

    public void undo(){
        this.undoController.undo();
    }

    public boolean undoable(){
        return this.undoController.undoable();
    }

    public void redo(){
        this.redoController.redo();
    }

    public boolean redoable(){
        return this.redoController.redoable();
    }

    public boolean areAllTokensOnBoard() {
        return this.actionController.areAllTokensOnBoard();
    }

    public boolean isTicTacToe() {
        return this.actionController.isTicTacToe();
    }

    public void next() {
        this.actionController.next();
    }

    public Error getOriginMoveTokenError(Coordinate coordinate) {
        return this.actionController.getOriginMoveTokenError(coordinate);
    }

    public Error getTargetMoveTokenError(Coordinate origin, Coordinate target) {
        return this.actionController.getTargetMoveTokenError(origin, target);
    }

    public void moveToken(Coordinate origin, Coordinate target) {
        this.actionController.moveToken(origin,target);

    }

    public Error getPutTokenError(Coordinate coordinate) {
        return this.actionController.getPutTokenError(coordinate);
    }

    public void putToken(Coordinate coordinate) {
        this.actionController.putToken(coordinate);
    }

    public Color getActiveColor() {
        return this.actionController.getActiveColor();
    }

    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }

}
