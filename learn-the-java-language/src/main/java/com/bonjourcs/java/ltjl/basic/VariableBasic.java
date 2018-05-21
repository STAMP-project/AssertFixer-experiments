package com.bonjourcs.java.ltjl.basic;

/**
 * @author Liang Chenghao
 * Description: basic usages for Java variable
 * Date: 2018/3/29
 */
public class VariableBasic {

    /**
     * class variable, also known as static field
     */
    private static final String TAG = "VARIABLE_USAGE";

    /**
     * integer literal
     */
    private static final int LIFECYCLE = 10_000_000;

    /**
     * instance variable, also known as non-static field
     */
    private int lifecycle;

    /**
     * a method shows usages of parameter and local variable
     *
     * @param name parameter name
     */
    public String foo(String name) {
        // foo is a local variable
        String foo = TAG + name;
        return foo;
    }

}
