package usantatecla.tictactoe.models;

class GameMemento {

    private Turn turn;
    private Board board;
    private Player[] players;

    GameMemento(Turn turn, Board board, Player[] players) {
        this.board = board.copy();
        this.players = players;
        this.turn = turn.copy(this.players);
    }

    Board getBoard() {
        return this.board;
    }

    Player[] getPlayers() {
        return this.players;
    }

    Turn getTurn() {
        return this.turn;
    }

}
