package com.bonjourcs.java.ltjl.generics;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/4/2
 */
public class PairTest {

    @Test
    public void testInstantiatePair() {

        // type inference
        Pair<String, String> pair1 = new Pair<>("KX", "KK");
        Pair<String, Integer> pair2 = new Pair<>("KX", 10);

        // type erasure
        Assert.assertTrue(pair1.getClass().equals(pair2.getClass()));
    }

}