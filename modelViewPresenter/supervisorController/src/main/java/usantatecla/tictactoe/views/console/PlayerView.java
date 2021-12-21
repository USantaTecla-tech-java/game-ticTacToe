package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.models.Player;
import usantatecla.tictactoe.views.Message;

public class PlayerView implements usantatecla.tictactoe.views.PlayerView {

    private Player player;

    PlayerView(Player player) {
        this.player = player;
    }

    public void writeWinner() {
        new MessageView().writeln(Message.PLAYER_WIN, this.player.getColor().name());
    }

}
