package com.cryptoeagle.service;

import com.cryptoeagle.AbstractTest;
import com.cryptoeagle.entity.Item;
import com.cryptoeagle.service.abst.RssService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertTrue;



public class RssServiceImplTest extends AbstractTest {

    @Autowired
    RssService rssService;

    @Test
    public void getItems() {

        List<Item> items = rssService.getItems("https://www.coindesk.com/feed/", "blog_test");
        assertTrue(items.size() > 10);

    }
}