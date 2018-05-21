package com.bonjourcs.java.ltjl.cao;

import org.junit.Test;

import java.util.Date;

/**
 * @author Liang Chenghao
 * Description: test for class Son
 * Date: 2018/3/29
 */
public class SonTest {

    @Test
    public void testInstantiateSon() {

        // object father is a instance of Class Son
        Father father = new Son("KX", new Date());
        System.out.println(father.getClass());

    }
}