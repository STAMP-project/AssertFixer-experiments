package ru.job4j.array;

/**
 * SubStringSearch
 *
 *
 * @author Sergey Petrov (sergey45684745@gmail.com)
 * @version $Id$
 * @since 0.1
 */



public class SubStringSearch {
    /**
     *Method returns true if the original string contains substring
     * @param origin - original string
     * @param sub - substring
     */
    public boolean contains(String origin, String sub) {
        boolean result = false;
        char[] arraySub = sub.toCharArray();
        char[] arrayOrigin = origin.toCharArray();
        int lengthCounter = 0;
        /**
         * This loop checks first char
         * @param lengthCounter to check all the chars matches
         * @param arraySupPointer This variable is used to go throu subStr
         */
        for (int out = 0; out < arrayOrigin.length - arraySub.length; out++) {
            lengthCounter = 0;
            for (int in = 0; in < arraySub.length; in++) {
                if (arrayOrigin[out + in] == arraySub[in]) {
                    lengthCounter++;
                }
            }
            if (lengthCounter == arraySub.length) {
                result = true;
                break;
            }
        }
        return result;
    }
}
