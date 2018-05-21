package com.bonjourcs.java.ltjl.generics;

/**
 * @author Liang Chenghao
 * Description: generic class Nodwe
 * Date: 2018/4/3
 */
public class Node<T> {

    /**
     * filed t
     */
    private T t;

    /**
     * constructor of Node
     *
     * @param t constructor parameter
     */
    public Node(T t) {
        setT(t);
    }

    protected void setT(T t) {
        System.out.println("Node set data");
        this.t = t;
    }
}
