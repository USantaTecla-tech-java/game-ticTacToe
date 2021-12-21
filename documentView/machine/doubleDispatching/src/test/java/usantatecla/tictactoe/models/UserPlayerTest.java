package usantatecla.tictactoe.models;

public class UserPlayerTest extends PlayerTest {

    @Override
    public PlayerBuilder getPlayerBuilder() {
        return new PlayerBuilder().color(this.COLOR).user();
    }

}
