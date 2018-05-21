package com.bonjourcs.java.ltjl.cao;

/**
 * @author Liang Chenghao
 * Description: class Outer shows usages of inner class
 * Date: 2018/3/29
 */
public class Outer {

    /**
     * define array size
     */
    private final static int ARRAY_SIZE = 10;
    /**
     * an integer array
     */
    private int[] array = new int[10];

    /**
     * initialize integer array when create a Outer object.
     */
    public Outer() {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            array[i] = (i + 1);
        }
    }

    /**
     * print number in array the index of which is even
     */
    public void print() {
        HelpClass helpClass = this.new HelpClass();
        helpClass.print();
    }

    /**
     * a print interface
     */
    interface Print {
    }

    /**
     * a help class implements interface Print
     */
    class HelpClass implements Print {
        public void print() {
            for (int i = 0; i < array.length; i++) {
                if (array[i] % 2 == 0) {
                    System.out.printf("%2d ", array[i]);
                }
            }
        }
    }

}
