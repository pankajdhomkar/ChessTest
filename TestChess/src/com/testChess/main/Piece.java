package com.testChess.main;

import java.util.Arrays;
import java.util.List;

public enum Piece {
	KING(Move.LEFT, Move.RIGHT, Move.UP, Move.DOWN, Move.UP_LEFT,
			Move.UP_RIGHT, Move.DOWN_LEFT, Move.DOWN_RIGHT),

	PAWN(Move.UP),

	HORSE(Move.UP_LEFT.then(Move.UP), Move.UP_LEFT.then(Move.LEFT),
			Move.UP_RIGHT.then(Move.UP), Move.UP_RIGHT.then(Move.RIGHT),
			Move.DOWN_LEFT.then(Move.DOWN), Move.DOWN_LEFT.then(Move.LEFT),
			Move.DOWN_RIGHT.then(Move.DOWN), Move.DOWN_RIGHT.then(Move.RIGHT)),

	ROOK(Move.UP.keepGoing(), Move.DOWN.keepGoing(),
			Move.LEFT.keepGoing(), Move.RIGHT.keepGoing()),

	BISHOP(Move.UP_LEFT.keepGoing(), Move.UP_RIGHT.keepGoing(),
			Move.DOWN_LEFT.keepGoing(), Move.DOWN_RIGHT.keepGoing()),

	QUEEN(Move.UP.keepGoing(), Move.DOWN.keepGoing(), Move.LEFT.keepGoing(), Move.RIGHT.keepGoing(),
			Move.UP_LEFT.keepGoing(), Move.UP_RIGHT.keepGoing(),
			Move.DOWN_LEFT.keepGoing(), Move.DOWN_RIGHT.keepGoing());


	private List<Move> possibleMoves;

	Piece(final Move ...possibleMoves) {
		this.possibleMoves = Arrays.asList(possibleMoves);
	}

	public List<Move> getPossibleMoves() {
		return possibleMoves;
	}

}
