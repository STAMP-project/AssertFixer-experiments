package ru.job4j.chess;

import ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.exceptions.OccupiedWayException;

/**
 * Пешка
 */
public class Pawn extends Figure implements WayValidator {
    Cell[] way;

    Pawn(Cell position) {
        super(position);
    }

    @Override
    Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException {
        if (this.validateDirection(source, dest)) {
            int stepY = 1;
            way = new Cell[dest.getY() - source.getY()]; // Столько будет ходов, если путь валидный
            for (int i = 0; i < way.length; i++) {
                way[i].setX(source.getX());
                way[i].setY(source.getY() + stepY++);
            }

            return way;
        }
        throw new ImpossibleMoveException("Невозможное движение для пешки");
    }

    @Override
    Figure copy(Cell dest) {
        return new Pawn(dest);
    }

    @Override
    public boolean validateDirection(Cell source, Cell dest) throws ImpossibleMoveException {
        boolean result = false;
        if (dest.getX() == source.getX() // Только вперед!
                && (dest.getY() - source.getY() == 1
                || (dest.getY() - source.getY() == 2 && source.getY() == 1) //Первый ход пешек возможен на две клетки
        )
                ) {
            result = true;
        }
        return result;
    }
}
