package com.bonjourcs.java.ltjl.iai;

import org.junit.Test;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/4/2
 */
public class SonTest {


    /**
     * Son can access Father's private field via Father's protected method
     */
    @Test
    public void testInheritance() {

        Father father = new Son("Pinkman");
        father.showInfo();

    }
}