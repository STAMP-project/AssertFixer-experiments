package com.techmisal.easy;


/*


Given a matrix A, return the transpose of A.

The transpose of a matrix is the matrix flipped over it's main diagonal, switching the row and column indices of the matrix.


 */

public class TransposeMatrix {


    public int[][] transpose(int[][] A) {


        int row = A.length;
        int col = A[0].length;

        int[][] B = new int[col][row];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                B[j][i] = A[i][j];


            }
        }


        return B;


    }


}
