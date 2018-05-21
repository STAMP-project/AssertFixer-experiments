package com.bonjourcs.java.ltjl.oop;

import org.junit.Test;

/**
 * @author Liang Chenghao
 * Description: tests for class Horse
 * Date: 2018/3/29
 */
public class HorseTest {

    @Test
    public void testEat() {
        Animal animal = new Horse();
        animal.eat();
    }

    @Test
    public void testBreathe() {
        Animal animal = new Horse();
        animal.breathe();
    }
}