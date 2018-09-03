package ru.job4j.jobparser;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @depth - is number of page to parse.
 * You can set number of pages to parse only with constructor
 * I future probably I will use kind of iterator with comparable date
 */
public class Parser {
    final static Logger LOG = Logger.getLogger(Parser.class);
    private int depth = 0;
    //todo deside what type of list I will use
    //todo make page input page number in get method
    private ParsedRow row = null;

    private Document connect() {
        Document document = null;
        try {
            LOG.info("Connection to 'sql.ru'...");
            document = Jsoup.connect(String.format("https://sql.ru/forum/job/%s", pageNumber())).get();
            LOG.info("Connected. Web page has been parsed...");
        } catch (IOException e) {
            LOG.error("Unable to connect to 'sql.ru'...", e);
        }
        return document;
    }

    public List<ParsedRow> get(int depth) {
        this.depth = depth;
        int counter = 0;
        Document document;
        Elements elements;
        List<ParsedRow> topics = new ArrayList<>();
        document = this.connect();
        do {
            elements = selectTable(document);
            topics.addAll(getRows(elements));
            counter++;
        } while (counter <= depth);
        return topics;
    }

    private Elements selectTable(Document document) {
        return document.select("tbody > tr");
    }

    private List<ParsedRow> getRows(Elements elements) {
        String date;
        List<ParsedRow> topics = new LinkedList<>();
        for (Element element : elements) {
            date = new String(element.select("td[style = text-align:center]").select("td[class = altCol]").text());
            if (!date.equals("")) {
                row = new ParsedRow(element.select("td[class = postslisttopic] > a").text(),
                        element.select("td[class = postslisttopic] > a").attr("href"),
                        new DateConverter(date).convert()
                );
                topics.add(row);
            }
        }
        LOG.info("Rows has been successfully parsed...");
        return topics;
    }

    private String pageNumber() {
        if (this.depth == 0) {
            return "";
        } else {
            return String.valueOf(depth);
        }
    }
}
