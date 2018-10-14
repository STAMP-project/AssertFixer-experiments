package com.cryptoeagle.service;

import com.cryptoeagle.entity.Event;
import com.cryptoeagle.repository.EventRepository;
import com.cryptoeagle.service.abst.EventService;
import com.cryptoeagle.service.abst.RestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;

@Service
@Slf4j
public class EventServiceImpl implements EventService {

    RestService restService;

    EventRepository repository;

    @Autowired
    public void  EventRepositoryImpl(RestService service, EventRepository repository){
        this.restService = service;
        this.repository = repository;
    }

    @Override
    public List<Event> getEvents(int count) {
        log.info("get events count: " + count);
        return restService.getEvents(count);
    }

    @Override
    public List<Event> getAll() {
        log.info("get all events ");
        return repository.getAll();
    }

    @Override

    @Transactional
    public void update() {
        log.info("update events :" + LocalDateTime.now());
        repository.deleteAll();
        List<Event> events = restService.getEvents(5);
        repository.saveAll(events);
    }
}
