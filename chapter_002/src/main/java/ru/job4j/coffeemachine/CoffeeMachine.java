package ru.job4j.coffeemachine;

class CoffeeMachine {

    int[] changes(int value, int price) {
        int change = value > price ? value - price : 0;
        int[] values = {10, 5, 2, 1};

        int numOfTen = change / 10;
        int numOfFive = (change - numOfTen * 10) / 5;
        int numOfTwo = (change - numOfTen * 10 - numOfFive * 5) / 2;
        int numOfOne = (change - numOfTen * 10 - numOfFive * 5 - numOfTwo * 2);
        int length = numOfTen + numOfFive + numOfTwo + numOfOne;

        int[] result = new int[length];
        int j = 0;
            for (int i : values) {
                while (change >= i) {
                    change = change - i;
                    result[j] = i;
                    j++;
                }
            }
        return result;
    }
}