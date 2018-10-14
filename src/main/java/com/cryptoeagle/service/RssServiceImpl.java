package com.cryptoeagle.service;


import com.cryptoeagle.Utils;
import com.cryptoeagle.entity.Item;
import com.cryptoeagle.exception.RssNewsNotFoundException;
import com.cryptoeagle.service.abst.RssService;
import com.rometools.rome.feed.synd.SyndContent;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
@Slf4j
public class RssServiceImpl implements RssService {

    public List<Item> getItems(String url, String source) {
        log.info("get items url : " + url + " source : " + source);
        SyndFeedInput input = new SyndFeedInput();
        SyndFeed feed = null;
        List<Item> itemList = null;
        //TODO cut
        try {

            feed = input.build(new XmlReader(new URL(url)));
            List<SyndEntry> list = feed.getEntries();
            itemList = new ArrayList<>();
            for (SyndEntry entry : list) {
                SyndContent desc = entry.getDescription();

                Date date = entry.getPublishedDate();

                LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
                String description = desc.getValue();
                String link = entry.getLink();
                String title = entry.getTitle();

                Item item = new Item();
                item.setSource(source);
                item.setTitle(Utils.clearString(title));
                item.setLink(link);
                String plain = Jsoup.parse(description).text();

                if (plain.length() > 150) {
                    plain = plain.substring(0, 150);
                }

                item.setDescription(plain);
                item.setPublishDate(localDateTime);

                itemList.add(item);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RssNewsNotFoundException("new not found");
        }

        return itemList;
    }

}