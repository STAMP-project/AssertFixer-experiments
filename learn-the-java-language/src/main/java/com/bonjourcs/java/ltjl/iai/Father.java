package com.bonjourcs.java.ltjl.iai;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/4/2
 */
public class Father {

    /**
     * field family name
     */
    private String familyName;

    public Father(String familyName) {
        this.familyName = familyName;
    }

    protected void showInfo() {
        System.out.println(familyName);
    }

    void doSomething(String name, int age) {
        // do something
    }

    static void foo(String name){}

}
