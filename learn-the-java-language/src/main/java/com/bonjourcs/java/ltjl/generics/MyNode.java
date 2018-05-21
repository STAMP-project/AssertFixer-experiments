package com.bonjourcs.java.ltjl.generics;

/**
 * @author Liang Chenghao
 * Description: generic class MyNode extends class Node
 * Date: 2018/4/3
 */
public class MyNode extends Node<Integer> {

    public MyNode(Integer integer) {
        super(integer);
    }

    @Override
    protected void setT(Integer integer) {
        System.out.println("MyNode set data");
        super.setT(integer);
    }

}
