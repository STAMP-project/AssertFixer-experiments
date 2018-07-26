package ru.job4j.array;
/**
 * @author Egor Novikov (e.novikov@yahoo.com)
 * Получает один массив сортированный в порядке возрастания из двух имеющихся сортированных по возрастанию.
 */
public class TwoMassiveInOne {
    public int[] twoInOne(int[] first, int[] second) {
        int el = first.length + second.length;
        int[] third = new int[el];
        int firstIndex = 0;
        int secondIndex = 0;
        for (int i = 0; i < el; i++) {
            if (firstIndex > first.length - 1) {
                third[i] = second[secondIndex];
                secondIndex++;
            } else if (secondIndex > second.length - 1) {
                third[i] = first[firstIndex];
                firstIndex++;
            } else if (i < el - 2) {
                if (first[firstIndex] >= second[secondIndex]) {
                    third[i] = second[secondIndex];
                    secondIndex++;
                } else {
                    third[i] = first[firstIndex];
                    firstIndex++;
                }
            } else if (i == el - 2) {
                if (first[firstIndex] >= second[secondIndex]) {
                    third[i] = second[secondIndex];
                    third[i + 1] = first[firstIndex];
                } else {
                    third[i] = first[firstIndex];
                    third[i + 1] = second[secondIndex];
                }
            }
        }
        return third;
    }
}

