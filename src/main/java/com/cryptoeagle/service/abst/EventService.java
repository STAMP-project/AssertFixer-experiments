package com.cryptoeagle.service.abst;

import com.cryptoeagle.entity.Event;

import java.util.List;

public interface EventService {

    List<Event> getEvents(int count);

    List<Event> getAll();

    void update();
}
