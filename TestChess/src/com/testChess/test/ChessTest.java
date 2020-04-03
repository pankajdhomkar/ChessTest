package com.testChess.test;
import java.util.List;

import org.junit.Test;

import com.testChess.main.Piece;

public class ChessTest {

	private com.testChess.main.Chess chess = com.testChess.main.Chess.createNewObject();
	
	@Test
	public void kingMovement() {
		try {
			System.out.println("King Movement  "+ chess.findAllNextPositions(Piece.KING, "D5"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void horseMovement() {
		try {
			System.out.println("Horse Movement " + chess.findAllNextPositions(Piece.HORSE, "E3"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}
