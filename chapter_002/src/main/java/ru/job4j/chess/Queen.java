package ru.job4j.chess;

import ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.exceptions.OccupiedWayException;

/**
 * Ферзь
 */
public class Queen extends Figure implements WayValidator {
    private Bishop temporyBisop = new Bishop(new Cell(0, 0));
    private Rook temporyRook = new Rook(new Cell(0, 0));

    Queen(Cell position) {
        super(position);
    }

    /**
     * На самом деле Ферзь не ходит
     * Ходит за него Слон или Ладья, но  возвращает свой путь Ферзь
     *
     * @param source
     * @param dest
     * @return
     * @throws ImpossibleMoveException
     * @throws OccupiedWayException
     */
    @Override
    Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException {
        if (this.validateDirection(source, dest)) { // Проверяем, можем ли мы ходить вообще
            Cell[] way;
            if (this.subValidator(source, dest)[0]) {

                way = temporyBisop.way(source, dest);
                return way; // Если мы ходим как слон, то за нас
                //походит слон, который вернет массив ходов.
            } else {

                way = temporyRook.way(source, dest);
                return way; // Если мы ходим как ладья, то за нас
                //походит ладья, которая вернет массив ходов.
            }
        }

        throw new ImpossibleMoveException("Невозможный ход Ферзя");
    }

    @Override
    Figure copy(Cell dest) {
        return new Queen(dest);
    }

    /**
     * * Почему так? Соогласно условию задачи нужно выдавать исключения
     * Поэтому, для того, чтобы выловить false в одном месте и true в другом
     * я обернул их в try/catch, чтобы валидаторы не крашились, а выдавали false
     * Потом я использую этот метод, чтобы определить, каким же образом ходит Ферзь
     *
     * @param source
     * @param dest
     * @return
     */
    public boolean[] subValidator(Cell source, Cell dest) {
        boolean[] result = new boolean[2];
        boolean bishopMarker;
        boolean rookMarker;

        try {
            bishopMarker = new Bishop(new Cell(0, 0)).validateDirection(source, dest);
        } catch (ImpossibleMoveException e) {
            e.printStackTrace();
            bishopMarker = false;
        }
        try {
            rookMarker = new Rook(new Cell(0, 0)).validateDirection(source, dest);
        } catch (ImpossibleMoveException e) {
            e.printStackTrace();
            rookMarker = false;
        }
        result[0] = bishopMarker; // Если ходит как слон
        result[1] = rookMarker; // Если ходит как ладья
        return result;
    }

    /**
     * @param source
     * @param dest
     * @return
     * @throws ImpossibleMoveException
     */
    @Override
    public boolean validateDirection(Cell source, Cell dest) throws ImpossibleMoveException {
        boolean result = false;

        if (this.subValidator(source, dest)[0] || this.subValidator(source, dest)[1]) { // Ферзь ходит как слон или как ладья

            result = true;
        } else {
            throw new ImpossibleMoveException("Недопустимый ход для ферзя");
        }
        return result;
    }
}
