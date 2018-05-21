package com.bonjourcs.java.ltjl.generics;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/4/2
 */
public class BoxTest {


    @Test
    @SuppressWarnings(value = "all")
    public void testInstantiateBox() {

        Box<String> box = new Box<>();
        Box anotherBox = box;
        box.set("box");

        // type erasure
        Assert.assertEquals("Box", box.getClass().getSimpleName());

    }
}