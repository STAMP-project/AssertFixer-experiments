package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.exceptions.FigureNotFoundException;
import ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.exceptions.OccupiedWayException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BoardTest {


    /**
     * Проверка метода move в целом
     *
     * @throws OccupiedWayException
     * @throws ImpossibleMoveException
     * @throws FigureNotFoundException
     */
    @Test
    public void whenBishopGoes() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Board board = new Board();
        Board.count = 0;
        Figure bishop = new Bishop(new Cell(3, 3));
        board.addFigure(bishop);
        boolean result = board.move(bishop.getPosition(), new Cell(2, 2));
        assertThat(result, is(true));
    }

    @Test
    public void whenBishopAddThenAdded() throws OccupiedWayException {
        Board board1 = new Board();
        Board.count = 0;
        Figure bishop1 = new Bishop(new Cell(0, 0));
        board1.addFigure(bishop1);
        assertThat(bishop1, is(board1.getFigures()[0]));
    }

    /**
     * validate free cell test
     *
     * @throws OccupiedWayException
     */

    @Test
    public void whenCellIsBusy() throws OccupiedWayException {
        Board board = new Board();
        Figure bishop = new Bishop(new Cell(0, 0));
        Figure bishop1 = new Bishop(new Cell(0, 0));
        board.addFigure(bishop);
        boolean result = board.validateFreeCell(bishop1.getPosition());
        assertThat(result, is(false));
    }


    /**
     * Метод берет координаты клеток и суммирует пройденные координаты для слона
     *
     * @throws OccupiedWayException
     * @throws ImpossibleMoveException
     */

    @Test
    public void whenBishopGoesThenGetWay() throws OccupiedWayException, ImpossibleMoveException {
        Board board = new Board();
        Figure bishop = new Bishop(new Cell(0, 0));
        board.addFigure(bishop);
        int resultInt = 0;
        Cell[] result = bishop.way(new Cell(0, 0), new Cell(5, 5));
        for (int i = 0; i < 5; i++) {
            resultInt = result[i].getX() + result[i].getY();
        }
        int expected = 10;
        assertThat(resultInt, is(expected));
    }

    /**
     * Тест на правильности пути слона
     *
     * @throws ImpossibleMoveException
     */

    @Test
    public void whenBishopGoesRightWay() throws ImpossibleMoveException {
        Bishop bishop = new Bishop(new Cell(0, 0));
        boolean result = bishop.validateDirection(bishop.getPosition(), new Cell(5, 5));
        assertThat(result, is(true));
    }

    /**
     * Тест правильности пути Ладьи
     *
     * @throws ImpossibleMoveException
     */

    @Test
    public void whenRookGoesRightWay() throws ImpossibleMoveException {
        Rook rook = new Rook(new Cell(0, 0));
        boolean result = rook.validateDirection(rook.getPosition(), new Cell(0, 5));
        assertThat(result, is(true));
    }

    /**
     * Метод берет координаты клеток и суммирует пройденные координаты для ладьи
     *
     * @throws OccupiedWayException
     * @throws ImpossibleMoveException
     */

    @Test
    public void whenRookGoesThenGetWayY() throws OccupiedWayException, ImpossibleMoveException {
        Board board = new Board();
        Figure rook = new Rook(new Cell(2, 2));
        board.addFigure(rook);
        Cell[] result = rook.way(new Cell(2, 2), new Cell(2, 6));
        int resultInt = result[0].getY() + result[1].getY() + result[2].getY() + result[3].getY();
        int expected = 3 + 4 + 5 + 6;
        assertThat(resultInt, is(expected));
    }

    /**
     * Метод берет координаты клеток и суммирует пройденные координаты для ладьи
     *
     * @throws OccupiedWayException
     * @throws ImpossibleMoveException
     */

    @Test
    public void whenRookGoesThenGetWayX() throws OccupiedWayException, ImpossibleMoveException {
        Board board = new Board();
        Figure rook = new Rook(new Cell(2, 2));
        board.addFigure(rook);
        Cell[] result = rook.way(new Cell(2, 2), new Cell(6, 2));
        int resultInt = result[0].getX() + result[1].getX() + result[2].getX() + result[3].getX();
        int expected = 3 + 4 + 5 + 6;
        assertThat(resultInt, is(expected));
    }

    /**
     * Тест правильности пути Ферзя по траектории Ладьи
     *
     * @throws ImpossibleMoveException
     */

    @Test
    public void whenQueenGoesLikeRookRightWay() throws ImpossibleMoveException {
        Queen queen = new Queen(new Cell(0, 0));
        boolean result = queen.validateDirection(queen.getPosition(), new Cell(0, 5));
        assertThat(result, is(true));
    }

    /**
     * Тест на правильности Ферзя по траекториипути слона
     *
     * @throws ImpossibleMoveException
     */

    @Test
    public void whenQueenGoesLikeBishopRightWay() throws ImpossibleMoveException {
        Queen queen = new Queen(new Cell(0, 0));
        boolean result = queen.validateDirection(queen.getPosition(), new Cell(5, 5));
        assertThat(result, is(true));
    }

    /**
     * Ферзь ходит как Ладья
     *
     * @throws OccupiedWayException
     * @throws ImpossibleMoveException
     */

    @Test
    public void whenQueenGoesLikeRookThenGetWay() throws OccupiedWayException, ImpossibleMoveException {
        Board board = new Board();
        Figure queen = new Queen(new Cell(3, 3));
        board.addFigure(queen);
        Cell[] result = queen.way(new Cell(3, 3), new Cell(3, 6));
        int resultInt = result[0].getY() + result[1].getY() + result[2].getY();
        int expected = 4 + 5 + 6;
        assertThat(resultInt, is(expected));
    }

    /**
     * Ферзь ходит как Слон
     *
     * @throws OccupiedWayException
     * @throws ImpossibleMoveException
     */

    @Test
    public void whenQueenGoesLikeBishopThenGetWay() throws OccupiedWayException, ImpossibleMoveException {
        Board board = new Board();
        Figure queen = new Queen(new Cell(0, 0));
        board.addFigure(queen);
        Cell[] result = queen.way(new Cell(0, 0), new Cell(1, 1));
        int resultInt = result[0].getX() + result[0].getY();
        int expected = 2;
        assertThat(resultInt, is(expected));
    }

    /**
     * Ход короля
     *
     * @throws OccupiedWayException
     * @throws ImpossibleMoveException
     */

    @Test
    public void whenKingGoesCorrectThenGetWay() throws OccupiedWayException, ImpossibleMoveException {
        Board board1 = new Board();
        Figure king = new King(new Cell(5, 5));
        board1.addFigure(king);
        Cell[] result = king.way(new Cell(5, 5), new Cell(6, 6));
        int resultInt = result[0].getX() + result[0].getY();
        int expected = 12;
        assertThat(resultInt, is(expected));
    }

    /**
     * Правильный ход короля
     *
     * @throws ImpossibleMoveException
     */

    @Test
    public void whenKingGoesCorrect() throws ImpossibleMoveException {
        King king = new King(new Cell(0, 0));
        boolean result = king.validateDirection(king.getPosition(), new Cell(1, 1));
        assertThat(result, is(true));
    }

    /**
     * Если король попытается уйти слишком далеко
     *
     * @throws ImpossibleMoveException
     */

    @Test
    public void whenKingGoesIncorrect() throws ImpossibleMoveException {
        King king = new King(new Cell(0, 0));
        boolean result = king.validateDirection(king.getPosition(), new Cell(5, 5));
        assertThat(result, is(false));
    }

    /**
     * Пешка идет на две клетки
     *
     * @throws ImpossibleMoveException
     */

    @Test
    public void whenPawnGoesCorrectFarAway() throws ImpossibleMoveException {
        Pawn pawn = new Pawn(new Cell(2, 1));
        boolean result = pawn.validateDirection(pawn.getPosition(), new Cell(2, 3));
        assertThat(result, is(true));
    }

    /**
     * Пешка идет на одну клетку
     *
     * @throws ImpossibleMoveException
     */

    @Test
    public void whenPawnGoesCorrect() throws ImpossibleMoveException {
        Pawn pawn = new Pawn(new Cell(2, 1));
        boolean result = pawn.validateDirection(pawn.getPosition(), new Cell(2, 2));
        assertThat(result, is(true));
    }

    /**
     * Пешка далеко не уйдет
     *
     * @throws ImpossibleMoveException
     */

    @Test
    public void whenPawnGoesInCorrect() throws ImpossibleMoveException {
        Pawn pawn = new Pawn(new Cell(2, 2));
        boolean result = pawn.validateDirection(pawn.getPosition(), new Cell(2, 4));
        assertThat(result, is(false));
    }

    /**
     * Правильный ход конем
     *
     * @throws ImpossibleMoveException
     */

    @Test
    public void whenKnightGoesCorrectThenValidateOK() throws ImpossibleMoveException {
        Knight knight = new Knight(new Cell(0, 0));
        boolean result = knight.validateDirection(knight.getPosition(), new Cell(2, 1));
        assertThat(result, is(true));
    }


    /**
     * Проверка пути коня
     *
     * @throws OccupiedWayException
     * @throws ImpossibleMoveException
     */

    @Test
    public void whenKnightGoesCorrectThenGetWay() throws OccupiedWayException, ImpossibleMoveException {
        Board board = new Board();
        Board.count = 0;
        Figure knight = new Knight(new Cell(5, 5));
        board.addFigure(knight);
        Cell[] result = knight.way(knight.getPosition(), new Cell(7, 6));
        int resultInt = result[0].getX() + result[1].getX() + result[2].getX() + result[0].getY() + result[1].getY() + result[2].getY();
        int expected = 6 + 5 + 7 + 5 + 7 + 6;
        assertThat(resultInt, is(expected));
    }

    /**
     * Проверка метода move  для коня, когда поля на пути пустые
     *
     * @throws OccupiedWayException
     * @throws ImpossibleMoveException
     * @throws FigureNotFoundException
     */
    @Test
    public void whenKnightMovesFreeThenGetMoved() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Board board = new Board();
        Board.count = 0;
        Figure knight = new Knight(new Cell(3, 3));
        board.addFigure(knight);
        boolean result = board.move(knight.getPosition(), new Cell(5, 4));
        assertThat(result, is(true));
    }

    /**
     * Проверка метода move  для коня, когда поля на пути фигуры пустые
     *
     * @throws OccupiedWayException
     * @throws ImpossibleMoveException
     * @throws FigureNotFoundException
     */
    @Test
    public void whenKnightMovesThoroughTheFiguresThenGetMoved() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Board board = new Board();
        Board.count = 0;
        Figure knight = new Knight(new Cell(3, 3));
        board.addFigure(knight);
        board.addFigure(new Pawn(new Cell(4, 3)));
        board.addFigure(new Pawn(new Cell(5, 3)));
        boolean result = board.move(knight.getPosition(), new Cell(5, 4));
        assertThat(result, is(true));
    }
}
