package com.bonjourcs.java.ltjl.foo;

import org.junit.Test;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/3/29
 */
public class SonTest {

    @Test
    public void testInstantiateSon(){
        // The access level of class Father is package-private,
        // a compiler error occurs in the following codes.
        // Father father = new Son("KX", new Date());
    }

}
