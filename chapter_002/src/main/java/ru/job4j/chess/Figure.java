package ru.job4j.chess;

import ru.job4j.chess.exceptions.FigureNotFoundException;
import ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.exceptions.OccupiedWayException;

abstract class Figure {
    private Cell position;

    public void setKnight(boolean knight) {
        isKnight = knight; // для того, чтобы понять, конь фигура или нет
    }

    private  boolean isKnight;

    public boolean isKnight() {
        return isKnight;
    }

    public Cell getPosition() {
        return position;
    }

    abstract Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException;

    abstract Figure copy(Cell dest);

    Figure(Cell position) {
        this.position = position;
    }

}
