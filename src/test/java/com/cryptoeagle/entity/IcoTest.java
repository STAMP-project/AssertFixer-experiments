package com.cryptoeagle.entity;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class IcoTest {

    private static final Ico ICO_1 = new Ico();
    private static final Ico ICO_2 = new Ico();


    static {

        ICO_1.setIcoStart(LocalDateTime.of(2018, 5, 1, 10, 00));

        ICO_2.setIcoStart(LocalDateTime.of(2018, 10, 1, 10, 00));

    }

    @Test
    public void todayMinusIcoStart() {
        assertTrue(ICO_1.todayMinusIcoStart() > 0);

        //todo test
    }

    @Test
    public void todayMinusIcoEnd() {

        assertTrue(ICO_1.todayMinusIcoEnd() > 0);
    }

}