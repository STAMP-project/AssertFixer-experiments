package ru.job4j.chess;

import ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.exceptions.OccupiedWayException;

import java.util.Arrays;

/**
 * Король
 */
public class King extends Figure implements WayValidator {
    private Queen temporyQueen = new Queen(new Cell(0, 0));

    King(Cell position) {
        super(position);
    }

    @Override
    Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException {
        if (this.validateDirection(source, dest)) {

            Cell[] way = temporyQueen.way(source, dest);
            return way;
        }
        throw new ImpossibleMoveException("Недопустимый ход для короля");
    }

    @Override
    Figure copy(Cell dest) {
        return new King(dest);
    }

    /**
     * Мы проверяем что король ходит как Ферзь (который ходит как слон и ладья)
     * Но только на одну клетку
     *
     * @param source
     * @param dest
     * @return
     * @throws ImpossibleMoveException
     */
    @Override
    public boolean validateDirection(Cell source, Cell dest) throws ImpossibleMoveException {
        boolean result = false;

        if (temporyQueen.validateDirection(source, dest)
                && (Math.abs(source.getX() - dest.getX()) == 1 // Какая-то из координат должна изменяться на 1,
                || Math.abs(source.getY() - dest.getY()) == 1 // Чтобы ход был валидным
        )
                ) {
            result = true;
        }
        return result;
    }
}
