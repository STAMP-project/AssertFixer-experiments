package ru.job4j.array;
/**Contains.
 *
 *@author Svetlana Egorova (s.sosenkova@gmail.com)
 *
 *@version $Id$
 *
 *@since 0.1
 */
public class Contains {
    boolean contains(String origin, String sub) {
        char[] data = origin.toCharArray();
        char[] value = sub.toCharArray();
        boolean result = true;
        for (int j = 0; j < data.length - value.length; j++) {
            for (int i = 0; i < value.length; i++) {
                result = true;
                if (data[i + j] != value[i]) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
}