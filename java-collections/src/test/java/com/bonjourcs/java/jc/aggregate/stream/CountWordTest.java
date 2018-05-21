package com.bonjourcs.java.jc.aggregate.stream;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/5/10
 */
public class CountWordTest {

    @Test
    public void testCountWord() {
        CountWord countWord = new CountWord();
        try {
            System.out.println("word's length more than 5 is : "
                    + countWord.countWord("stream.txt", 5));
        } catch (IOException e) {
            Assert.fail("read file error.");
        } catch (URISyntaxException e) {
            Assert.fail("build path error.");
        }
    }

}