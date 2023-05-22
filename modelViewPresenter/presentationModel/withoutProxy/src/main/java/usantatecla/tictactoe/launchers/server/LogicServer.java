package usantatecla.tictactoe.launchers.server;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.launchers.server.dispatchers.BoardCompleteDispatcher;
import usantatecla.tictactoe.launchers.server.dispatchers.ChangeTurnDispatcher;
import usantatecla.tictactoe.launchers.server.dispatchers.ContinueStateDispatcher;
import usantatecla.tictactoe.launchers.server.dispatchers.CoordinateValidDispatcher;
import usantatecla.tictactoe.launchers.server.dispatchers.CreatePlayersDispatcher;
import usantatecla.tictactoe.launchers.server.dispatchers.DimensionDispatcher;
import usantatecla.tictactoe.launchers.server.dispatchers.DispatcherPrototype;
import usantatecla.tictactoe.launchers.server.dispatchers.EmptyTokenDispatcher;
import usantatecla.tictactoe.launchers.server.dispatchers.FrameType;
import usantatecla.tictactoe.launchers.server.dispatchers.MoveTokenDispatcher;
import usantatecla.tictactoe.launchers.server.dispatchers.PlayerTypeDispatcher;
import usantatecla.tictactoe.launchers.server.dispatchers.PutTokenDispatcher;
import usantatecla.tictactoe.launchers.server.dispatchers.RandomCoordinateDispatcher;
import usantatecla.tictactoe.launchers.server.dispatchers.ResumeDispatcher;
import usantatecla.tictactoe.launchers.server.dispatchers.StartDispatcher;
import usantatecla.tictactoe.launchers.server.dispatchers.StateDispatcher;
import usantatecla.tictactoe.launchers.server.dispatchers.TicTacToeDispatcher;
import usantatecla.tictactoe.launchers.server.dispatchers.TokenCharDispatcher;
import usantatecla.tictactoe.launchers.server.dispatchers.ValueTurnDispatcher;
import usantatecla.tictactoe.launchers.server.dispatchers.errors.ErrorsMoveOriginDispatcher;
import usantatecla.tictactoe.launchers.server.dispatchers.errors.ErrorsMoveTargetDispatcher;
import usantatecla.tictactoe.launchers.server.dispatchers.errors.ErrorsPutDispatcher;
import usantatecla.tictactoe.launchers.server.dispatchers.undoredo.RedoDispatcher;
import usantatecla.tictactoe.launchers.server.dispatchers.undoredo.RedoableDispatcher;
import usantatecla.tictactoe.launchers.server.dispatchers.undoredo.UndoDispatcher;
import usantatecla.tictactoe.launchers.server.dispatchers.undoredo.UndoableDispatcher;

public class LogicServer extends Logic {

	public LogicServer(Boolean isStandalone) {
		super(isStandalone);
	}

	public void createDispatchers(DispatcherPrototype dispatcherPrototype) {
		dispatcherPrototype.add(FrameType.START, new StartDispatcher(this.startController));
		dispatcherPrototype.add(FrameType.CREATE_PLAYERS, new CreatePlayersDispatcher(this.startController));
		dispatcherPrototype.add(FrameType.STATE, new StateDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.UNDO, new UndoDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.REDO, new RedoDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.UNDOABLE, new UndoableDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.REDOABLE, new RedoableDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.PLAYER_TYPE, new PlayerTypeDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.COORDINATE_VALID, new CoordinateValidDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.BOARD_COMPLETE, new BoardCompleteDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.CHANGE_TURN, new ChangeTurnDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.TOKEN_CHAR, new TokenCharDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.EMPTY_TOKEN, new EmptyTokenDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.DIMENSION, new DimensionDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.TICTACTOE, new TicTacToeDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.RANDOM_COORDINATE, new RandomCoordinateDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.ERRORS_PUT, new ErrorsPutDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.ERRORS_MOVE_ORIGIN, new ErrorsMoveOriginDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.ERRORS_MOVE_TARGET, new ErrorsMoveTargetDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.PUT_TOKEN, new PutTokenDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.MOVE_TOKEN, new MoveTokenDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.VALUE_TURN, new ValueTurnDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.CONTINUE_STATE, new ContinueStateDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.NEW_GAME, new ResumeDispatcher(this.resumeController));
	}

}
