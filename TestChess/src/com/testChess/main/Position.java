package com.testChess.main;

import java.util.Objects;

public class Position {
	private static int A_ASCII = (int) 'A';
	private static int H_ASCII = (int) 'H';

	private char column;
	private int row;

	private Position(final char column, final int row) {
		this.column = column;
		this.row = row;
	}

	public static Position parse(final String stringPosition) throws Exception{
		if (stringPosition == null || stringPosition.length() != 2) {
			throw new IllegalArgumentException("Incorrect Position " + stringPosition);
		}

		final char column = stringPosition.charAt(0);
		final char row = stringPosition.charAt(1);
		try {
			final int rowNumber = Integer.parseInt(String.valueOf(row));

			if (column < A_ASCII || column > H_ASCII || rowNumber < 1 || rowNumber > 8) {
				throw new IllegalArgumentException("Incorrect Position " + stringPosition + " out of range");
			}

			return new Position(column, rowNumber);
		} catch (final NumberFormatException nfe) {
			throw new IllegalArgumentException("Incorrect Position " + stringPosition, nfe);
		}
	}

	boolean canMoveLeft() {
		return column > A_ASCII;
	}

	Position moveLeft() {
		return new Position((char) (column - 1), row);
	}

	Position moveRight() {
		return new Position((char) (column + 1), row);
	}

	Position moveUp() {
		return new Position(column, row + 1);
	}

	Position moveDown() {
		return new Position(column, row - 1);
	}

	Position moveUpLeft() {
		return this.moveUp().moveLeft();
	}

	Position moveUpRight() {
		return this.moveUp().moveRight();
	}

	Position moveDownLeft() {
		return this.moveDown().moveLeft();
	}

	Position moveDownRight() {
		return this.moveDown().moveRight();
	}

	boolean canMoveRight() {
		return column < H_ASCII;
	}

	boolean canMoveUp() {
		return row < 8;
	}

	boolean canMoveDown() {
		return row > 1;
	}

	boolean canMoveUpLeft() {
		return canMoveLeft() && canMoveUp();
	}

	boolean canMoveUpRight() {
		return canMoveUp() && canMoveRight();
	}

	boolean canMoveDownLeft() {
		return canMoveDown() && canMoveLeft();
	}

	boolean canMoveDownRight() {
		return canMoveDown() && canMoveRight();
	}

	@Override
	public String toString() {
		return String.valueOf(column) + row;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final Position position = (Position) o;
		return column == position.column &&
				row == position.row;
	}

	@Override
	public int hashCode() {
		return Objects.hash(column, row);
	}

}
