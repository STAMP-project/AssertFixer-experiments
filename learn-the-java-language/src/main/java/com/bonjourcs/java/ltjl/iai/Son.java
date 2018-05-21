package com.bonjourcs.java.ltjl.iai;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/4/2
 */
public class Son extends Father {

    public Son(String familyName) {
        super(familyName);
    }

    /**
     * override
     *
     * @param name
     * @param age
     */
    @Override
    void doSomething(String name, int age) {

    }

    /**
     * not override
     *
     * @param age
     * @param name
     */
    void doSomething(int age, String name) {
    }

    // instance method cannot 'override' static method in superclass
//    void foo(String name){
//
//    }

}
