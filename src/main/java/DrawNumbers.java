/**
 * @author Pavel Belov
 * Lab №1 Task 5
 * Displaying a number as drawing characters.
 */


public class DrawNumbers {
    public static void main (String[] args)
    {
        String numbers = args[0];                       //numbers from cmd
        String[][] arrayNumbers = new String [10][7];

        arrayNumbers [0][0] = ("   ***   ");
        arrayNumbers [0][1] = ("  *   *  ");
        arrayNumbers [0][2] = (" *     * ");
        arrayNumbers [0][3] = (" *     * ");
        arrayNumbers [0][4] = (" *     * ");
        arrayNumbers [0][5] = ("  *   *  ");
        arrayNumbers [0][6] = ("   ***   ");

        arrayNumbers [1][0] = ("   *   ");
        arrayNumbers [1][1] = ("  **   ");
        arrayNumbers [1][2] = (" * *   ");
        arrayNumbers [1][3] = ("   *   ");
        arrayNumbers [1][4] = ("   *   ");
        arrayNumbers [1][5] = ("   *   ");
        arrayNumbers [1][6] = (" ***** ");

        arrayNumbers [2][0] = ("  ***  ");
        arrayNumbers [2][1] = (" *   * ");
        arrayNumbers [2][2] = (" *  *  ");
        arrayNumbers [2][3] = ("   *   ");
        arrayNumbers [2][4] = ("  *    ");
        arrayNumbers [2][5] = (" *     ");
        arrayNumbers [2][6] = (" ***** ");

        arrayNumbers [3][0] = ("  ***  ");
        arrayNumbers [3][1] = ("     * ");
        arrayNumbers [3][2] = ("     * ");
        arrayNumbers [3][3] = ("  ***  ");
        arrayNumbers [3][4] = ("     * ");
        arrayNumbers [3][5] = ("     * ");
        arrayNumbers [3][6] = ("  ***  ");

        arrayNumbers [4][0] = ("    *  ");
        arrayNumbers [4][1] = ("   **  ");
        arrayNumbers [4][2] = ("  * *  ");
        arrayNumbers [4][3] = (" *  *  ");
        arrayNumbers [4][4] = (" ***** ");
        arrayNumbers [4][5] = ("    *  ");
        arrayNumbers [4][6] = ("    *  ");

        arrayNumbers [5][0] = ("  **** ");
        arrayNumbers [5][1] = ("  *    ");
        arrayNumbers [5][2] = ("  *    ");
        arrayNumbers [5][3] = ("  ***  ");
        arrayNumbers [5][4] = ("     * ");
        arrayNumbers [5][5] = ("     * ");
        arrayNumbers [5][6] = ("  ***  ");

        arrayNumbers [6][0] = ("  ***  ");
        arrayNumbers [6][1] = (" *     ");
        arrayNumbers [6][2] = (" *     ");
        arrayNumbers [6][3] = (" ****  ");
        arrayNumbers [6][4] = (" *   * ");
        arrayNumbers [6][5] = (" *   * ");
        arrayNumbers [6][6] = ("  ***  ");

        arrayNumbers [7][0] = (" ***** ");
        arrayNumbers [7][1] = ("     * ");
        arrayNumbers [7][2] = ("    *  ");
        arrayNumbers [7][3] = ("   *   ");
        arrayNumbers [7][4] = ("  *    ");
        arrayNumbers [7][5] = (" *     ");
        arrayNumbers [7][6] = (" *     ");

        arrayNumbers [8][0] = ("  ***  ");
        arrayNumbers [8][1] = (" *   * ");
        arrayNumbers [8][2] = (" *   * ");
        arrayNumbers [8][3] = ("  ***  ");
        arrayNumbers [8][4] = (" *   * ");
        arrayNumbers [8][5] = (" *   * ");
        arrayNumbers [8][6] = ("  ***  ");

        arrayNumbers [9][0] = ("  *** ");
        arrayNumbers [9][1] = (" *   * ");
        arrayNumbers [9][2] = (" *   * ");
        arrayNumbers [9][3] = ("  **** ");
        arrayNumbers [9][4] = ("     * ");
        arrayNumbers [9][5] = ("     * ");
        arrayNumbers [9][6] = ("  ***  ");

        //The length () method returns the length of a string in Java.
        //The charAt () method returns a character at the specified row index.
        //The getNumericValue (char ch) returns the int value that the specified Unicode character represents.

            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < numbers.length(); j++) {
                    int number = Character.getNumericValue(numbers.charAt(j));
                    System.out.print(arrayNumbers[number][i]);
                }
                System.out.print("\n");
            }
        }
}





