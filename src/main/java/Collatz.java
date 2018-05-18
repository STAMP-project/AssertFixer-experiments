/**
 * @author Belov Pavel
 * Lab №1 Task 1
 * Find the largest Collatz sequence for numbers in the range from 1 to 1 000 000.
 */

public class Collatz {
    public static void main(String[] args) {

        int m = 1000000;
        long maxLength = 1;         //maximum length of sequence
        long tmp = 0;               //temporary variable for curremt length of sequence
        long maxNumber = 1;         //number with maximum length sequence

        for (long i = 1; i <= m; i++) {
            tmp = CollatzCalculation(i);
            if (tmp > maxNumber) {
                maxLength = tmp;
                maxNumber = i;
            }
        }
        System.out.println("The maximum length of sequence:" + maxLength + " The maximum number:" + maxNumber);
    }

    public static long CollatzCalculation(long n) {

        long currentLength = 1;         //current length of sequence

        //counting the Collatz sequence
        while (n != 1) {
            currentLength++;
            if (n % 2 == 0)
                n = n / 2;
            else
                n = n * 3 + 1;
        }
        return currentLength;
    }
}
