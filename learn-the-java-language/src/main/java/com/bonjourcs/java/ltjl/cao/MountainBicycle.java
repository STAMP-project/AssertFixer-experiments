package com.bonjourcs.java.ltjl.cao;

/**
 * @author Liang Chenghao
 * Description: class MountainBicycle extends class Bicycle
 * Date: 2018/3/29
 */
public class MountainBicycle extends Bicycle {

    {
        System.out.println("A mountain bicycle is initializing..");
    }

    static {
        System.out.println("static initialization block in MountainBicycle.");
    }

}
