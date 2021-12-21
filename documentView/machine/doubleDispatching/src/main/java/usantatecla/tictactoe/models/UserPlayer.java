package usantatecla.tictactoe.models;

import usantatecla.tictactoe.types.Color;

public class UserPlayer extends Player {

    UserPlayer(Color color, Board board) {
        super(color, board);
    }

    @Override
    public void accept(PlayerVisitor playerVisitor) {
        playerVisitor.visit(this);
    }

}
