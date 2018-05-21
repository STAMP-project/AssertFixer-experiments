package com.bonjourcs.java.ltjl.cao;

/**
 * @author Liang Chenghao
 * Description: class Bicycle
 * Date: 2018/3/29
 */
public class Bicycle {

    /**
     * class variable for class Bicycle
     */
    private static int serialId = 0;

    /**
     * instance variable
     */
    private String brand;

    /*
     * initializer block
     */ {
        System.out.println("A bicycle is initializing...");
    }

    /*
     * static initialization block#1
     */
    static {
        System.out.println("static initialization block#1 in class Bicycle");
    }

    /**
     * add serialId with 1 when every instantiation method was invoked
     */
    public Bicycle() {
        serialId++;
        showInfo();
    }

    /**
     * pass brand to constructor
     *
     * @param brand brand of bicycle
     */
    public Bicycle(String brand) {
        this.brand = brand;
        serialId++;
        showInfo();
    }

    /*
     * static initialization block#2
     */
    static {
        System.out.println("static initialization block#2 in class Bicycle");
    }

    /***
     * instance method shows the brand and serialId of a bicycle
     */
    public void showInfo() {
        System.out.println("A " + this.brand + " bicycle #" + serialId);
    }

    // setters and getters...

    // can't invoked via this.getSerialId()
    public static int getSerialId() {
        return serialId;
    }

    public static void setSerialId(int serialId) {
        Bicycle.serialId = serialId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
