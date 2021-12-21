package usantatecla.tictactoe;

import usantatecla.utils.BoundedIntDialog;

class Turn {

    private final Board board;
    static final int NUMBER_PLAYERS = 2;
    private final Player[] players;
    private int activePlayer;

    Turn(Board board) {
        assert board != null;
        this.board = board;
        this.players = new Player[Turn.NUMBER_PLAYERS];
        this.reset();
    }

    void reset() {
        BoundedIntDialog dialog = new BoundedIntDialog(0, Turn.NUMBER_PLAYERS);
        int numberUsers = dialog.read(Message.NUMBER_PLAYERS.toString());
        for (int i = 0; i < Turn.NUMBER_PLAYERS; i++) {
            if (i < numberUsers) {
                this.players[i] = new UserPlayer(Color.get(i), this.board);
            } else {
                this.players[i] = new MachinePlayer(Color.get(i), this.board);
            }
        }
        this.activePlayer = 0;
    }

    void play() {
        this.players[this.activePlayer].play();
        if (!this.board.isTicTacToe(this.getActiveColor())) {
            this.activePlayer = (this.activePlayer + 1) % Turn.NUMBER_PLAYERS;
        }
    }

    void writeWinner() {
        this.players[this.activePlayer].writeWinner();
    }

    Color getActiveColor() {
        return this.players[this.activePlayer].getColor();
    }

}
