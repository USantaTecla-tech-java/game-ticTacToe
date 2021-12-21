package usantatecla.tictactoe.views;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.models.MachinePlayer;
import usantatecla.tictactoe.models.PlayerVisitor;
import usantatecla.tictactoe.models.UserPlayer;

class PlayView extends WithGameView implements PlayerVisitor {

    PlayView(Game game) {
        super(game);
    }

    void interact() {
        do {
            this.game.getActivePlayer().accept(this);
            this.game.next();
            new BoardView().write(this.game);
        } while (!this.game.isTicTacToe());
        Message.PLAYER_WIN.writeln(this.game.getActiveColor().name());
    }

    @Override
    public void visit(UserPlayer userPlayer) {
        new UserPlayerView(userPlayer).interact();
    }

    @Override
    public void visit(MachinePlayer machinePlayer) {
        new MachinePlayerView(machinePlayer).interact();
    }
    
}