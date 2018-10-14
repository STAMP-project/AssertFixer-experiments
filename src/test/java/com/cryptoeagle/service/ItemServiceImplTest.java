package com.cryptoeagle.service;

import com.cryptoeagle.AbstractTest;
import com.cryptoeagle.entity.Item;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ItemServiceImplTest extends AbstractTest {

    private static final int ITEMS_COUNT = 100;
    private static final String ITEM_SOURCE1 = "walletinvestor";
    private static final int ITEM_SOURCE1_COUNT = 10;
    private static final int SOURCE_COUNT = 7;

    @Autowired
    ItemServiceImpl service;

    @Test
    public void getAll() {
        List<Item> all = service.getAll();
        assertTrue(all.size() == ITEMS_COUNT);
    }

    @Test
    public void delete() {
        List<Item> all = service.getAll();
        assertTrue(all.size() == ITEMS_COUNT);
    }

    @Test
    public void getBySource() {
        List<Item> items = service.getBySource(ITEM_SOURCE1);
        assertTrue(items.size() == ITEM_SOURCE1_COUNT);
    }

    @Test
    public void getSources() {
        List<String> items = service.getSources();
        assertTrue(items.size() == SOURCE_COUNT);
    }

}