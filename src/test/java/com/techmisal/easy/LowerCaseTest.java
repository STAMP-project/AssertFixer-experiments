package com.techmisal.easy;

import org.junit.Assert;
import org.junit.Test;

public class LowerCaseTest {


    LowerCase lowerCase = new LowerCase();

    @Test
    public void toLowerCaseTest(){


        Assert.assertEquals(lowerCase.toLowerCase("Hello"),"hello");

    }

}
