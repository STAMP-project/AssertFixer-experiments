package com.bonjourcs.java.ltjl.generics;

import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.*;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/4/2
 */
public class NumberUtilsTest {

    /**
     * data format pattern
     */
    private final String DATE_FORMAT = "yyyyMMdd";

    @Test
    public void testCountGreaterThan() throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

        // people list
        People[] peoples = new People[3];
        peoples[0] = new People(dateFormat.parse("19980101"));
        peoples[1] = new People(dateFormat.parse("19980201"));
        peoples[2] = new People(dateFormat.parse("19980401"));

        // people to be compared
        People people = new People(dateFormat.parse("19980301"));

        // use generic method
        Assert.assertEquals(1, NumberUtils.countGreaterThan(peoples, people));

    }

}