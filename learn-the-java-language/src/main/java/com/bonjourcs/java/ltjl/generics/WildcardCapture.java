package com.bonjourcs.java.ltjl.generics;

import java.util.List;

/**
 * @author Liang Chenghao
 * Description: class for wildcard capture
 * Date: 2018/4/3
 */
public class WildcardCapture {

    /**
     * get an element from a list and set back
     *
     * @param list element list
     */
    public void foo(List<?> list) {
        // compile error
//        list.set(0, list.get(0));
        fooHelper(list);
    }

    /**
     * helper method
     *
     * @param list list
     * @param <T>  type
     */
    private <T> void fooHelper(List<T> list) {
        list.set(0, list.get(0));
    }

}
