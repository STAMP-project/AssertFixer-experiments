package com.bonjourcs.java.ltjl.generics;

import org.junit.Test;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/4/3
 */
public class MyNodeTest {


    @Test
    public void testInstantiateMyNode() {

        // MyNode set data
        // Node set data
        MyNode myNode = new MyNode(10);

        Node node = myNode;
        // this causes an ClassCaseException
//        node.setT("Hello");

    }

}