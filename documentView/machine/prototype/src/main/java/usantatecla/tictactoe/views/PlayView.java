package usantatecla.tictactoe.views;

import usantatecla.tictactoe.models.Game;

class PlayView extends WithGameView {

    private PlayerViewPrototype playerViewPrototype;

    PlayView(Game game) {
        super(game);
        this.playerViewPrototype = new PlayerViewPrototype();
    }

    void interact() {
        do {
            PlayerView playerView = this.playerViewPrototype.createView(this.game.getType());
            playerView.interact(this.game);
            this.game.next();
            new BoardView().write(this.game);
        } while (!this.game.isTicTacToe());
        Message.PLAYER_WIN.writeln(this.game.getActiveColor().name());
    }
}