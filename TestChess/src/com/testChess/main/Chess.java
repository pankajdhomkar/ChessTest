package com.testChess.main;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class Chess {

	public static Chess createNewObject() {
		return new Chess();
	}

	public List<String> findAllNextPositions(final Piece piece, final String currentPosition) throws Exception {
		final Position position = Position.parse(currentPosition);
		return piece.getPossibleMoves()
				.stream()
				.map(move -> move.perform(position))
				.filter(Optional::isPresent)
				.map(Optional::get)
				.map(p -> p.toString())
				.collect(Collectors.toList());
	}
}
