package ru.job4j.chess;

import ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.exceptions.OccupiedWayException;


/**
 * Конь
 */
public class Knight extends Figure implements WayValidator {
    private Cell[] way = new Cell[5];

    Knight(Cell position) {
        super(position);
        this.setKnight(true); // Мы говорим, что мы конь
    }

    /**
     * Мы разделяем весь ход конем на два подхода
     * создаем вспомогательную лалью
     * И делаем два хода этой ладьей, а потом суммируем
     * то, что получилось
     *
     * @param source
     * @param dest
     * @return
     * @throws ImpossibleMoveException
     * @throws OccupiedWayException
     */
    @Override
    Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException {
        if (this.validateDirection(source, dest)) {
            Cell[] way;
            int x, y;

            if (Math.abs((source.getX() - dest.getX())) > 1) {
                y = source.getY();
                x = dest.getX();
            } else {
                x = source.getX();
                y = dest.getY();
            }

            Cell halfDest = new Cell(x, y);
            Rook rookHelper = new Rook(source);
            way = rookHelper.way(source, halfDest);
            Cell[] endCell = {dest};

            System.arraycopy(way, 0, this.way, 0, 2);
            System.arraycopy(endCell, 0, this.way, 2, 1);
            return this.way;
        } else {
            throw new ImpossibleMoveException("Невозможный ход Конем");
        }
    }

    @Override
    Figure copy(Cell dest) {
        return new King(dest);
    }

    @Override
    public boolean validateDirection(Cell source, Cell dest) throws ImpossibleMoveException {
        boolean result;
        if ((Math.abs(source.getX() - dest.getX()) == 2 && Math.abs(source.getY() - dest.getY()) == 1)
                || (Math.abs(source.getY() - dest.getY()) == 2 && Math.abs(source.getX() - dest.getX()) == 1)
                ) {
            result = true;
        } else {
            throw new ImpossibleMoveException("Недопустимый ход Конем");
        }
        return result;
    }
}
