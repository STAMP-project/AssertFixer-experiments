package com.bonjourcs.java.common.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/4/17
 */
public class PropertyUtilsTest {

    @Test
    public void testGetProperty() {

        System.out.println(PropertyUtils.getProperty("bannerLocation"));

    }
}