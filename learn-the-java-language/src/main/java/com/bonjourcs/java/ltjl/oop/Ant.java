package com.bonjourcs.java.ltjl.oop;

/**
 * @author Liang Chenghao
 * Description: class Ant
 * Date: 2018/3/29
 */
public class Ant implements Animal {

    @Override
    public void eat() {
        System.out.println("Ant eats.");
    }

    @Override
    public void breathe() {
        System.out.println("Ant breathes.");
    }

}
