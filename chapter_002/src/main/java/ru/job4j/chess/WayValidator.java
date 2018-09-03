package ru.job4j.chess;

import ru.job4j.chess.exceptions.ImpossibleMoveException;

/**
 * Этот интерфейс заставляет проверять траекторию пути
 */
public interface WayValidator {
    boolean validateDirection(Cell source, Cell dest) throws ImpossibleMoveException;
}
