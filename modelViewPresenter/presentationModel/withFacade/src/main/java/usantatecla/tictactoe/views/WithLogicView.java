package usantatecla.tictactoe.views;

import usantatecla.tictactoe.controllers.Logic;

public abstract class WithLogicView {

    protected Logic logic;

    public WithLogicView(Logic logic) {
        this.logic = logic;
    }
    
}
