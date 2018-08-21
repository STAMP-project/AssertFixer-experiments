package ru.job4j.coffee;
/**
 * @author Egor Novikov (e.novikov@yahoo.com)
 * Класс осуществляющий подсчет монет для выдачи сдачи в кофемашине.
 */
import java.util.Arrays;

public class CoffeeMashine {

    private final int[] coin = new int[]{10, 5, 2, 1};

    public int[] coins(int value, int price) {
        int sum = value - price;
        int[] result = new int[50];
        int x = 0;
        for (int i = 0; i < coin.length; i++) {
            for (int j = 0; j < 100; j++) {
                if (sum - coin[i] >= 0) {
                    sum -= coin[i];
                    result[x] = coin[i];
                    x++;
                } else if (sum - coin[i] < 0) {
                    j = 100;
                }
            }
        }
        result = Arrays.copyOf(result, x);
        return result;
    }
}
