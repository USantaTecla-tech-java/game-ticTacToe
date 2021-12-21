package usantatecla.tictactoe.views;

import usantatecla.tictactoe.types.Coordinate;

class MachinePlayerView extends PlayerView {

    @Override
    protected Coordinate getCoordinate(Message message) {
        return this.game.getRandomCoordinate();
    }
}
