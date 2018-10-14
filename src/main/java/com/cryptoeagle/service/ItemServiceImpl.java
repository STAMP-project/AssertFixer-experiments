package com.cryptoeagle.service;

import com.cryptoeagle.entity.Blog;
import com.cryptoeagle.entity.Item;
import com.cryptoeagle.exception.ItemNotFoundException;
import com.cryptoeagle.repository.ItemRepository;
import com.cryptoeagle.service.abst.BlogService;
import com.cryptoeagle.service.abst.ItemService;
import com.cryptoeagle.service.abst.RssService;
import com.rometools.rome.feed.synd.SyndContent;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ItemServiceImpl implements ItemService {

    ItemRepository repository;

    RssService service;

    @Autowired
    public void ItemServiceImpl(ItemRepository repository, RssService service) {
        this.repository = repository;
        this.service = service;
    }

    @Override
    public List<Item> getAll() {
        log.info("get all");
        List<Item> itemList = repository.getAll();
        
        if (itemList == null)
            throw new ItemNotFoundException("get all not found");

        return itemList;
    }

    @Override
    public List<String> getSources() {
        log.info("get sources");
        return repository.getSources();
    }

    @Override
    public List<Item> getBySource(String source) {
        log.info("get by source :" + source);
        try {
            List<Item> items = repository.getBySource(source);
            if (items.size() == 0)
                throw new ItemNotFoundException("Size  0");
            else return items;
        } catch (Exception e) {
            log.error("ItemNotFoundException");
            throw new ItemNotFoundException(e.getMessage());
        }
    }

}
