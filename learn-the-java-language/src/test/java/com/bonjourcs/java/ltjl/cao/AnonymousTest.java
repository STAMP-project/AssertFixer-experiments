package com.bonjourcs.java.ltjl.cao;

import org.junit.Test;

/**
 * @author Liang Chenghao
 * Description: test for class Anonymous
 * Date: 2018/3/29
 */
public class AnonymousTest {

    @Test
    public void testGreet() {
        Anonymous anonymous = new Anonymous();
        anonymous.greet("TX", name ->
            System.out.println("Hello: " + name)
        );
    }

}