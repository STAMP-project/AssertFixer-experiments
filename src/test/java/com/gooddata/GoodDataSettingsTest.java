/*
 * Copyright (C) 2004-2017, GoodData(R) Corporation. All rights reserved.
 * This source code is licensed under the BSD-style license found in the
 * LICENSE.txt file in the root directory of this source tree.
 */
package com.gooddata;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class GoodDataSettingsTest {

    private GoodDataSettings settings;

    @BeforeMethod
    public void setUp() throws Exception {
        settings = new GoodDataSettings();
    }

    @Test
    public void testHasDefaults() throws Exception {
        assertTrue(settings.getMaxConnections() > 0);
        assertTrue(settings.getConnectionTimeout() >= 0);
        assertTrue(settings.getConnectionRequestTimeout() >= 0);
        assertTrue(settings.getSocketTimeout() >= 0);
        assertTrue(settings.getPollSleep() >= 0);
        assertThat(settings.getUserAgent(), is(nullValue()));
    }

    @Test
    public void testSetSeconds() throws Exception {
        settings.setConnectionTimeoutSeconds(53);
        settings.setConnectionRequestTimeoutSeconds(69);
        settings.setSocketTimeoutSeconds(71);
        settings.setPollSleepSeconds(81);

        assertEquals(53000, settings.getConnectionTimeout());
        assertEquals(69000, settings.getConnectionRequestTimeout());
        assertEquals(71000, settings.getSocketTimeout());
        assertEquals(81000, settings.getPollSleep());
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void setNegativeConnectionTimeoutFails() throws Exception {
        settings.setConnectionTimeout(-3);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void setNegativeConnectionRequestTimeoutFails() throws Exception {
        settings.setConnectionRequestTimeout(-1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void setNegativeSocketTimeoutFails() throws Exception {
        settings.setSocketTimeout(-5);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void setNegativePollSleepFails() throws Exception {
        settings.setPollSleep(-5);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void setZeroMaxConnectionsFails() throws Exception {
        settings.setMaxConnections(0);
    }

    @Test
    public void customUserAgentShouldBePrefixOfDefault() {
        GoodDataSettings goodDataSettings = new GoodDataSettings();
        goodDataSettings.setUserAgent("customAgent/X.Y");
        assertThat(goodDataSettings.getUserAgent(), is("customAgent/X.Y"));
    }

    @Test
    public void shouldVerifyEquals() throws Exception {
        EqualsVerifier.forClass(GoodDataSettings.class)
                .usingGetClass()
                .suppress(Warning.NONFINAL_FIELDS)
                .verify();
    }
}