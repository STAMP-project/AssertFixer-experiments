package com.brave.tradebravely.web.rest.util;

import org.junit.Test;
import org.springframework.http.HttpHeaders;

import static com.brave.tradebravely.web.rest.util.HeaderUtil.APPLICATION_NAME;
import static org.junit.Assert.*;

public class HeaderUtilTest {

    @Test
    public void createEntityCreationAlert() {
        final HttpHeaders alert = HeaderUtil.createEntityCreationAlert("entity", "param");
        assertEquals("A new entity is created with identifier param", alert.getFirst("X-" + APPLICATION_NAME + "-alert"));
    }

    @Test
    public void createEntityUpdateAlert() {
        final HttpHeaders alert = HeaderUtil.createEntityUpdateAlert("entity", "param");
        assertEquals("A entity is updated with identifier param", alert.getFirst("X-" + APPLICATION_NAME + "-alert"));
    }

    @Test
    public void createEntityDeletionAlert() {
        final HttpHeaders alert = HeaderUtil.createEntityDeletionAlert("entity", "param");
        assertEquals("A entity is deleted with identifier param", alert.getFirst("X-" + APPLICATION_NAME + "-alert"));
    }
}
