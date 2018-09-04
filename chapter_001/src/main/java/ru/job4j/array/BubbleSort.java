package ru.job4j.array;

/**
 * Class BubbleSort решение задачи части 001 урок 5.1.
 *
 * @author Kirillovykh Andrei (andykirill@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class BubbleSort {
	/**
	* Chees.
	* @param array - first args.
	* @return result.
	*/
    public int[] sort(int[] array) {
		for (int i = array.length - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		return array;
	}
}