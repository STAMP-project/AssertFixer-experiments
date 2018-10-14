package com.techmisal.hard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
Empty cells are indicated by the character '.'.

Note:

The given board contain only digits 1-9 and the character '.'.
You may assume that the given Sudoku puzzle will have a single unique solution.
The given board size is always 9x9.

Input 

53..7....
6..195...
.98....6.
8...6...3
4..8.3..1
7...2...6
.6....28.
...419..5
....8..79

TLE
1....8...
.8.74.1.5
..792..3.
9..1....4
2.......1
4....5..3
.2..548..
8.4.97.1.
...8....6
*/
public class SudokuSolver {

	public void solveSudoku(char[][] board) {
		solve(board);
    }
	
	private boolean solve(char[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if(board[i][j] == '.') {
					for(int value = 49; value <= 57; value++) {
						if(isValidValueForCell(board, i, j, (char) value)) {
							board[i][j] = (char) value;
							if(solve(board)) {
								return true;
							} else {
								board[i][j] = '.';
							}
						}
					}
					return false;
				}
			}
		}
		
		return true;
	}

	private boolean isValidValueForCell(char[][] board, int row, int col, char value) {
		return isValidValueForRow(board, row, value) && isValidValueForCol(board, col, value) && isValidValueForSubBox(board, row, col, value);
	}
	
	private boolean isValidValueForRow(char[][] board, int row, char value) {
		for(int i = 0; i < 9; i++) {
			if(board[row][i] == value)
				return false;
		}
		return true;
	}
	
	private boolean isValidValueForCol(char[][] board, int col, char value) {
		for(int i = 0; i < 9; i++) {
			if(board[i][col] == value)
				return false;
		}
		return true;
	}
	
	private boolean isValidValueForSubBox(char[][] board, int row, int col, char value) {
		int subRow = getSubBoxStartRowCol(row);
		int subCol = getSubBoxStartRowCol(col);
		for (int i = subRow; i < subRow + 3; i++) {
			for (int j = subCol; j < subCol + 3; j++) {
				if (board[i][j] == value)
					return false;
			}
		}
		return true;
	}

	private int getSubBoxStartRowCol(int index) {
		if (index >= 0 && index <= 2)
			return 0;
		if (index >= 3 && index <= 5)
			return 3;
		if (index >= 6 && index <= 8)
			return 6;
		return 0;
	}

	private char[][] getSampleBoard() throws IOException {
		char[][] board = new char[9][9];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		int row = 0;
		while(row < 9 && (line = br.readLine()) != null) {
			for(int i = 0; i < 9; i++) {
				board[row][i] = line.charAt(i);
			}
			row++;
		}
		return board;
	}
	
	private void printBoard(char[][] board) {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws IOException {
		SudokuSolver obj = new SudokuSolver();
		char[][] board = obj.getSampleBoard();
		obj.solveSudoku(board);
		obj.printBoard(board);
	}
}