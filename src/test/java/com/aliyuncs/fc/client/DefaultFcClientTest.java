package com.aliyuncs.fc.client;

import com.aliyuncs.fc.config.Config;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class DefaultFcClientTest {

    @Test
    public void testGetHeaderWithoutMd5() {
        Config config = new Config("", "", "", "", "", false);

        DefaultFcClient fcClient = new DefaultFcClient(config);

        Map<String, String> headers = new HashMap<String, String>();

        headers.put("x-fc-date", "x-fc-date-value");

        headers = fcClient.getHeader(headers, "123".getBytes(), null);
    }
}