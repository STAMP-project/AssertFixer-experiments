package com.bonjourcs.java.play.common;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/4/17
 */
public class ShowBannerTest {

    @Test
    public void testRun() {
        try {
            ShowBanner.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}