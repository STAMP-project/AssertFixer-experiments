package com.bonjourcs.java.ltjl.generics;

/**
 * @author Liang Chenghao
 * Description: generic class Box
 * Date: 2018/4/2
 */
public class Box<T> {

    /**
     * an object that Box can hold
     */
    private T t;

    public T get() {
        return this.t;
    }

    public void set(T t) {
        this.t = t;
    }

}
