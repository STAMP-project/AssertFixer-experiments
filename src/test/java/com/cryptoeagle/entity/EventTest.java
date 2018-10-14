package com.cryptoeagle.entity;

import org.junit.Test;

import java.time.ZonedDateTime;

import static org.junit.Assert.*;

public class EventTest {

    private static final Event EVENT = new Event();

    static {

        EVENT.setCoinName("ETH");
        EVENT.setDescription("desc");
        EVENT.setHot(true);
        EVENT.setProof("proof");
        EVENT.setSource("source");
        EVENT.setDate_event(ZonedDateTime.now());
    }

    @Test
    public void diffNowBeetweenDataEventDay() {

        //todo test

//        assertTrue(EVENT.diffNowBeetweenDataEventDay() < 0);
    }

    @Test
    public void diffNowBeetweenDataEventMinute() {

        //todo test

//        assertTrue(EVENT.diffNowBeetweenDataEventMinute() < 0);
    }
}