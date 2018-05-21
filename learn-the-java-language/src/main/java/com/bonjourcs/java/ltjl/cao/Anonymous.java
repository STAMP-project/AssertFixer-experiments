package com.bonjourcs.java.ltjl.cao;

/**
 * @author Liang Chenghao
 * Description: anonymous class
 * Date: 2018/3/29
 */
public class Anonymous {

    interface Greet {
        void greet(String name);
    }

    public void greet(String name, Greet greet) {
        greet.greet(name);
    }

}
