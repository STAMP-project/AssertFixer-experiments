package com.techmisal.medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
The given board contain only digits 1-9 and the character '.'.
The given board size is always 9x9.

Input which is true

53..7....
6..195...
.98....6.
8...6...3
4..8.3..1
7...2...6
.6....28.
...419..5
....8..79

Input which is false
83..7....
6..195...
.98....6.
8...6...3
4..8.3..1
7...2...6
.6....28.
...419..5
....8..79
*/
public class ValidSudoku {

	public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if(board[i][j] != '.') {
					if(!isValidValueForCell(board, i, j, board[i][j])) {
						return false;
					}
				}
			}
		}
		return true;
    }

	private boolean isValidValueForCell(char[][] board, int row, int col, char value) {
		return isValidValueForRow(board, row, col, value) && isValidValueForCol(board, row, col, value) && isValidValueForSubBox(board, row, col, value);
	}
	
	private boolean isValidValueForRow(char[][] board, int row, int col, char value) {
		for(int i = 0; i < 9; i++) {
			if(i == col) {
				continue;
			} else if(board[row][i] == value) {
				return false;
			}
		}
		return true;
	}
	
	private boolean isValidValueForCol(char[][] board, int row, int col, char value) {
		for(int i = 0; i < 9; i++) {
			if(i == row) {
				continue;
			} else if(board[i][col] == value) {
				return false;
			}
		}
		return true;
	}
	
	private boolean isValidValueForSubBox(char[][] board, int row, int col, char value) {
		int subRow = getSubBoxStartRowCol(row);
		int subCol = getSubBoxStartRowCol(col);
		for (int i = subRow; i < subRow + 3; i++) {
			for (int j = subCol; j < subCol + 3; j++) {
				if(i == row && j == col) {
					continue;
				} else if (board[i][j] == value) {
					return false;
				}
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

	public static void main(String[] args) throws IOException {
		ValidSudoku obj = new ValidSudoku();
		char[][] board = obj.getSampleBoard();
		System.out.println(obj.isValidSudoku(board));
	}
}