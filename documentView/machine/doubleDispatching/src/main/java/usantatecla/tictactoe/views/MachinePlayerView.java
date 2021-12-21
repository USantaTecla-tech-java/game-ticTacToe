package usantatecla.tictactoe.views;

import usantatecla.tictactoe.models.MachinePlayer;
import usantatecla.tictactoe.types.Coordinate;

class MachinePlayerView extends PlayerView {

    MachinePlayerView(MachinePlayer machinePlayer) {
        super(machinePlayer);
    }

    @Override
    protected Coordinate getCoordinate(Message message) {
        return ((MachinePlayer) this.player).getRandomCoordinate();
    }
    
}
