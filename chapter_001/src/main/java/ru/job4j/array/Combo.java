package ru.job4j.array;
/**Combo.
 *
 *@author Svetlana Egorova (s.sosenkova@gmail.com)
 *
 *@version $Id$
 *
 *@since 0.1
 */
public class Combo {
    public int[] combo(int[] firstArray, int[] secondArray) {
        int[] comboArray = new int[firstArray.length + secondArray.length];
        int k = 0;
        int i = 0;
        int j = 0;
        while (k < comboArray.length && i < firstArray.length && j < secondArray.length) {
            if (firstArray[i] <= secondArray[j]) {
                comboArray[k] = firstArray[i];
                i++;
            } else {
                comboArray[k] = secondArray[j];
                j++;
            }
            k++;
        } while (i < firstArray.length) {
            comboArray[k] = firstArray[i];
            i++;
            k++;
        } while (j < secondArray.length) {
            comboArray[k] = secondArray[j];
            j++;
            k++;
        }
        return comboArray;
    }
}