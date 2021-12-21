package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Session;

public class StartController extends Controller implements AcceptorController {

    public StartController(Session session) {
        super(session);
    }

    public void accept(ControllersVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }

}
