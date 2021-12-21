package usantatecla.tictactoe.views;

import usantatecla.tictactoe.controllers.Logic;

public abstract class View extends WithLogicView {

    public View(Logic logic) {
        super(logic);
    }

    public abstract void start();

    public abstract void play();

    public abstract boolean resume();

}
