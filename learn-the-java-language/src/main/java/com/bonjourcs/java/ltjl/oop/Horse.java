package com.bonjourcs.java.ltjl.oop;

/**
 * @author Liang Chenghao
 * Description: class Horse
 * Date: 2018/3/29
 */
public class Horse implements Animal {

    @Override
    public void eat() {
        System.out.println("Horse eats.");
    }

    @Override
    public void breathe() {
        System.out.println("Horse breathes.");
    }

}
