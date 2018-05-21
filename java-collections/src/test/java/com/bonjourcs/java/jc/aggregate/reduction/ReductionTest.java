package com.bonjourcs.java.jc.aggregate.reduction;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Liang Chenghao
 * Description: reduction test
 * Date: 2018/5/10
 */
public class ReductionTest {

    /**
     * test max reduction
     */
    @Test
    public void testMax() {
        Assert.assertTrue(!"".equals(Stream.of("Hello", "World", "This", "is")
                .max(String::compareToIgnoreCase)
                .orElse("")));
    }

    /**
     * test findAny reduction
     */
    @Test
    public void testFindAny() {
        Assert.assertTrue(
                Stream.of("Hi", "There", "Ok").anyMatch(s -> s.startsWith("H"))
        );
    }

    /**
     * test findAny with throwing exception
     */
    @Test(expected = RuntimeException.class)
    public void testOptional() {
        Stream.of("Hi", "world").filter(e -> e.startsWith("Q")).findAny().orElseThrow(RuntimeException::new);
    }

    /**
     * find and print specific string
     */
    @Test
    public void testPresent() {
        Stream.of("Hi", "World", "Kernel").filter(s -> s.startsWith("H")).findAny().ifPresent(System.out::println);
    }

    /**
     * collect operation test
     */
    @Test
    public void testCollection() {
        System.out.println(Stream.of("Hello", "World", "I", "am", "coming")
                .map(String::toUpperCase)
                .collect(Collectors.joining("-")));
        Stream.iterate(1, e-> e+1).limit(10).forEach(System.out::println);
    }

}