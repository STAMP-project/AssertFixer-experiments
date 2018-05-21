package com.bonjourcs.java.ltjl.generics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/4/3
 */
public class SubtypeTest {

    @Test
    public void testGenericSubtype() {

        // valid
        List<? super Fruit> list = new ArrayList<>();
        list.add(new Fruit());
        list.add(new Apple());
        list.add(new Pineapple());

        Pineapple pineapple = (Pineapple) list.get(2);

        // valid
        List<? super Pineapple> list1 = new ArrayList<Fruit>();
        // invalid
//        list1.add(new Fruit());
        list1.add(new Pineapple());
        Fruit fruit = (Fruit)list1.get(0);

    }

}
