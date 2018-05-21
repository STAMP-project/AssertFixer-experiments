package com.bonjourcs.java.ltjl.cao;

import org.junit.Test;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/3/29
 */
public class BicycleTest {

    @Test
    public void testInstantiateBicycle() {

        Bicycle bicycle1 = new Bicycle();
        Bicycle bicycle2 = new Bicycle();
        Bicycle bicycle3 = new Bicycle();
        System.out.println(Bicycle.getSerialId());
    }

    @Test
    public void testInstantiateMountainBicycle() {

        // initializer block will be copied into every constructor by compiler
        MountainBicycle mountainBicycle = new MountainBicycle();
        System.out.println("--------");
        Bicycle bicycle = new MountainBicycle();

    }

    @Test
    public void testInstantiateBicycleWithBrand() {

        // initializer block will be copied into every constructor by compiler
        Bicycle bicycle = new Bicycle("V2EX");

    }
}