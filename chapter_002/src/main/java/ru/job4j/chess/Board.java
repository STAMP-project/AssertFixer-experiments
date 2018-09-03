package ru.job4j.chess;

import ru.job4j.chess.exceptions.FigureNotFoundException;
import ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.exceptions.OccupiedWayException;

/**
 * Шахматная доска
 */
public class Board {
    public Figure[] getFigures() {
        return figures;
    }

    private Figure[] figures = new Figure[32];
    static int count = 0;

    boolean move(Cell source, Cell dest) throws ImpossibleMoveException,
            OccupiedWayException, FigureNotFoundException {
        boolean result = false;
        for (Figure figure : figures
                ) {
            if (!validateFreeCell(source)) { //проверяем не пуста ли клетка
                Cell[] way = (figure.way(source, dest));
                // Отдельный блок хода для коня
                if (figure.isKnight() && !validateFreeCell(dest)) {
                    throw new OccupiedWayException("Путь занят");
                }
                for (Cell cell : way) {
                    if (cell != null
                            && !validateFreeCell(cell)
                            && !figure.isKnight()) { // Чтобы в эту проверку не попал конь
                        throw new OccupiedWayException("Путь занят");
                    }
                }
            } else {
                throw new FigureNotFoundException("Клетка пустая");
            }
            figure.copy(dest);
            return true;
        }
        return result;
    }

    public boolean validateFreeCell(Cell cell) {
        boolean result = true;
        for (Figure figure : figures
                ) {
            if (figure != null
                    && figure.getPosition().getX() == cell.getX()
                    && figure.getPosition().getY() == cell.getY()) {
                result = false;
            }
        }
        return result;
    }

    /**
     * Добавление фигуры
     *
     * @param figure
     * @throws OccupiedWayException
     */
    public void addFigure(Figure figure) throws OccupiedWayException {
        if (this.validateFreeCell(figure.getPosition())) {
            figures[count++] = figure;
        } else {
            throw new OccupiedWayException("Данное поле уже занято");
        } //TODO Посмотреть как реализовать ход конем
    }
}
