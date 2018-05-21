package com.bonjourcs.java.ltjl.generics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/4/3
 */
public class WildcardCaptureTest {

    @Test
    public void testFoo() {

        List<String> list = new ArrayList<>(1);
        list.add("TX");

        new WildcardCapture().foo(list);

    }

}