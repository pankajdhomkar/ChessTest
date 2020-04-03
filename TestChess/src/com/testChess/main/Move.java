package com.testChess.main;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;


class Move {

    static final Move LEFT = new Move(Position::canMoveLeft, Position::moveLeft);
    static final Move RIGHT = new Move(Position::canMoveRight, Position::moveRight);
    static final Move UP = new Move(Position::canMoveUp, Position::moveUp);
    static final Move DOWN = new Move(Position::canMoveDown, Position::moveDown);
    static final Move UP_LEFT = new Move(Position::canMoveUpLeft, Position::moveUpLeft);
    static final Move UP_RIGHT = new Move(Position::canMoveUpRight, Position::moveUpRight);
    static final Move DOWN_LEFT = new Move(Position::canMoveDownLeft, Position::moveDownLeft);
    static final Move DOWN_RIGHT = new Move(Position::canMoveDownRight, Position::moveDownRight);

    private Predicate<Position> canMove;
    private Function<Position, Position> move;

    public Move(final Predicate<Position> canMove, final Function<Position, Position> move) {
        this.canMove = canMove;
        this.move = move;
    }

    public Optional<Position> perform(final Position currentPosition) {
        if (canMove.test(currentPosition)) {
            return Optional.of(move.apply(currentPosition));
        }
        return Optional.empty();
    }

    public Move keepGoing() {
        final Predicate<Position> andPredicate = (p) ->  {
            Position temp = p;
            while (canMove.test(temp)) {
                temp = this.move.apply(temp);
            }
            return !p.equals(temp);
        };
        final Function<Position, Position> andMove = (p) -> {
            Position temp = p;
            while (canMove.test(temp)) {
                temp = this.move.apply(temp);
            }
            return temp;
        };
        return new Move(andPredicate, andMove);
    }

    public Move then(final Move anotherMove) {
        final Predicate<Position> andPredicate = (p) -> canMove.test(p) && anotherMove.canMove.test(move.apply(p));
        final Function<Position, Position> andMove = (p) -> anotherMove.move.apply(this.move.apply(p));
        return new Move(andPredicate, andMove);
    }
}
