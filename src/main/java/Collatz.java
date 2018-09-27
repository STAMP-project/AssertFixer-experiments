/**
 * Created with IntelliJ IDEA.
 * User: Nasibulin
 * Date: 17.09.18
 * Time: 8:26
 * To change this template use File | Settings | File Templates.
 */
public class Collatz {
    static int maxLength;
    static int maxSeqNum;
    static final int MAX_NUM = 1000000;

    public static void collatz(long n) {
        maxLength = 1;
        //System.out.print(n + " ");
        if (n == 1) ; //System.out.println();
        else if (n % 2 == 0) {
            collatz(n / 2);
            maxLength++;
        } else {
            collatz(3 * n + 1);
            maxLength++;
        }
        ;
    }

    public static void main(String[] args) {
        //int N = Integer.parseInt(args[0]);
        int L = maxLength;
        int N = maxSeqNum;
        for (int i = 1; i <= MAX_NUM; i++) {
            collatz(i);
            if (Collatz.maxLength > L) {
                L = Collatz.maxLength;
                N = i;
            }
        }
        System.out.println("Максимальная длина последовательности: " + L);
        System.out.println("Число: " + N);
    }
    public static int MaxCollatz(int max_num){
        int L = maxLength;
        int N = maxSeqNum;
        for (int i = 1; i <= max_num; i++) {
            collatz(i);
            if (Collatz.maxLength > L) {
                L = Collatz.maxLength;
                N = i;
            }
        }
        return N;
        }
}
