package ru.job4j.coffemachine;

import java.util.ArrayList;
import java.util.List;

public class CoffeeMachine {
    public int[] changes(int value, int price) {

        List<Integer> list = new ArrayList<>();
        int moneyToChange = value - price;
        int dozens, fives, twos, ones;
        //int mainIndex = 0;

        dozens = moneyToChange / 10;
        fives = (moneyToChange - dozens * 10) / 5;
        twos = (moneyToChange - dozens * 10 - fives * 5) / 2;
        ones = (moneyToChange - dozens * 10 - fives * 5 - twos * 2);
        /*dozens*/
        if (dozens > 0) {
            for (int i = 0; i < dozens; i++) {
                list.add(10);
            }
        }
        /*fives*/
        if (fives > 0) {
            for (int i = 0; i < fives; i++) {
                list.add(5);
            }
        }
        /*twos*/
        if (twos > 0) {
            for (int i = 0; i < twos; i++) {
                list.add(2);
            }
        }
        /*ones*/
        if (ones > 0) {
            for (int i = 0; i < ones; i++) {
                list.add(1);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;

    }
}
