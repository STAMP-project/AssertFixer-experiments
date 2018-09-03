package ru.job4j.chess;

import ru.job4j.chess.exceptions.ImpossibleMoveException;

/**
 * Слон(офицер)
 */
public class Bishop extends Figure implements WayValidator {

    private Cell[] way;

    Bishop(Cell position) {
        super(position);
    }

    Figure copy(Cell dest) {
        return new Bishop(dest);
    }

    @Override
    Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        int stepX = source.getX() + 1, stepY = source.getY() + 1;
        int deltaX = Integer.compare(source.getX(), dest.getX());
        int deltaY = Integer.compare(source.getY(), dest.getY());
        int size = Math.abs(dest.getX() - source.getX());
        Cell[] way1 = new Cell[size];
        //todo сравнить как сделали ребята с курса
        if (validateDirection(source, dest)) {
            for (int i = 0; i < size; i++) {
                way1[i] = new Cell(source.getX(), source.getY());
                if (deltaX < 0) {
                    way1[i].setX(stepX++);
                } else {
                    way1[i].setX(stepX--);
                }
                if (deltaY < 0) {
                    way1[i].setY(stepY++);
                } else {
                    way1[i].setY(stepY--);
                }
            }
            this.way = way1;
        }
        return this.way;
    }

    @Override
    public boolean validateDirection(Cell source, Cell dest) throws ImpossibleMoveException {
        boolean result;
        if (Math.abs(dest.getX() - source.getX()) == Math.abs(dest.getY() - source.getY())) { // Движение по диагонали
            result = true;
        } else {
            throw new ImpossibleMoveException("Этот ход не возможен для слона");
        }
        return result;
    }

}
