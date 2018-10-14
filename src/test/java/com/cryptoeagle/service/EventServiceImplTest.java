package com.cryptoeagle.service;

import com.cryptoeagle.AbstractTest;
import com.cryptoeagle.entity.Event;
import com.cryptoeagle.service.abst.EventService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class EventServiceImplTest extends AbstractTest {

    @Autowired
    EventService eventService;

    @Test
    public void getEvents() {
        List<Event> events = eventService.getEvents(5);
        assertTrue(events.size() == 5);
    }

    @Test
    public void getAll() {
        List<Event> all = eventService.getAll();
        assertTrue(all.size() == 12);
    }

    @Test
    public void update() {

       //todo !!!!!
        eventService.update();

    }
}