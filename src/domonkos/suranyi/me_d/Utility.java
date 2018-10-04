package domonkos.suranyi.me_d;

import java.util.Arrays;


public enum Utility {
    ;

    /**
     * This function picks a part of an existing array and converts this part to an integer value.
     * 
     * @param array
     *            the array of bytes
     * @param index
     *            the index of the first byte of the requested part
     * @param length
     *            the number of bytes from {@code array[index]} to be converted to an integer. It's value can be 4 at
     *            maximum.
     * 
     * @return the calculated integer value
     * @throws IllegalArgumentException
     *             if the length is higher than 4 or negative
     */
    public static int getInt(final byte[] array, final int index, final int length) throws IllegalArgumentException {
        if (length > 4 || length < 0)
            throw new IllegalArgumentException("The defined length is out of integer range");
        return intArrayToInt(Arrays.copyOfRange(array, index, index + length));
    }

    /**
     * This function convert an array of bytes (type int) to an integer.
     * Only use within the range of an integer otherwise it may overflow.
     * 
     * @param array
     *            an array of bytes
     * @return the integer value created from the array
     */
    public static int intArrayToInt(final byte[] array) {
        int ret = 0;
        for (int i = 0; i < array.length; i++)
            ret += (array[array.length - 1 - i] & 0xFF) << i * 8;
        return ret;
    }
}
