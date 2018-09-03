package ru.job4j.chess;

import ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.exceptions.OccupiedWayException;

/**
 * Ладья
 */
public class Rook extends Figure implements WayValidator {

    private Cell[] way;

    Rook(Cell position) {
        super(position);
    }

    @Override
    Figure copy(Cell dest) {
        return new Rook(dest);
    }

    @Override
    Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException {
        //TODO Что-то здесь нечисто
        int stepX = source.getX(), stepY = source.getY();
        Cell[] way;
        if (validateDirection(source, dest)) {
            if (Math.abs(dest.getX() - source.getX()) != 0) {
                way = new Cell[Math.abs(dest.getX() - source.getX())]; // Столько будет ходов, если путь валидный
                for (int i = 0; i < way.length; i++) { //количество ходов
                    if (source.getX() < dest.getX() && source.getX() != dest.getX()) {
                        way[i] = new Cell(0, 0); // Просто инициализация
                        way[i].setX(++stepX);
                        way[i].setY(dest.getY());
                    } else {
                        way[i].setX(--stepX);
                        way[i].setY(dest.getY());
                    }
                }
            } else {
                way = new Cell[Math.abs(dest.getY() - source.getY())];
                for (int i = 0; i < way.length; i++) {
                    way[i] = new Cell(0, 0); // Просто инициализация
                    if (source.getY() < dest.getY() && source.getY() != dest.getY()) {
                        way[i].setY(++stepY);
                        way[i].setX(dest.getX());
                    } else {
                        way[i].setY(--stepY);
                        way[i].setX(dest.getX());
                    }
                }
            }
            this.way = way;
        }
        return this.way;
    }

    @Override
    public boolean validateDirection(Cell source, Cell dest) throws ImpossibleMoveException {
        boolean result = false;
        if (Math.abs(dest.getX() - source.getX()) == 0 || Math.abs(dest.getY() - source.getY()) == 0) { // Движение по горизонтали
            result = true;
        } else {
            throw new ImpossibleMoveException("Этот ход не возможен для ладьи");
        }
        return result;
    }
}
