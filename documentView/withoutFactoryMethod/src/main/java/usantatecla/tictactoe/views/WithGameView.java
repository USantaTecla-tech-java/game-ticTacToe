package usantatecla.tictactoe.views;

import usantatecla.tictactoe.models.Game;

public abstract class WithGameView {

    protected Game game;

    protected WithGameView(Game game) {
        this.game = game;
    }
    
}
