package com.bonjourcs.java.ltjl.cao;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/3/29
 */
public class LocalClassTest {

    @Test
    public void testValidateNumber() {

        LocalClass.validateNumber("123-456-7990", "xx-xx-xx", 10);

    }
}