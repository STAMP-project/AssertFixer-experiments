package ru.job4j.jobparser;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SQLParserConverterTest {
    /**
     * date converter
     */
    @Test
    public void whenConvertDateThenGetResult() {
        DateConverter converter = new DateConverter("01 янв 01, 00:00");
        Date date = new Date(converter.convert());
        String expected = "Mon Jan 01 00:00:00 MSK 2001";
        assertThat(date.toString(), is(expected));
    }

    @Test
    public void whenConvertTodayThenGetResult() {
        DateConverter converter = new DateConverter("сегодня, любое время");
        Date date = new Date(converter.convert());

        assertTrue(Math.abs(converter.convert() - (System.currentTimeMillis())) < 1000);
    }

    @Test
    public void whenConvertYesterdayThenGetResult() {
        DateConverter converter = new DateConverter("вчера, после обеда");
        Date date = new Date(converter.convert());
        assertTrue(Math.abs(converter.convert() - ((System.currentTimeMillis()) - 86400000)) < 1000);
    }

    @Test
    public void whenConvertInValideDateThenGetErrorButItStillWorks() {
        DateConverter converter = new DateConverter("после дождика в четверг");
        Date date = new Date(converter.convert());
        assertTrue(Math.abs(converter.convert() - ((System.currentTimeMillis()))) < 1000);
    }

    /**
     * String validator
     */
    @Test
    public void whenStringContainsJavaThenTrue() {
        StringSearcher searcher = new StringSearcher();
        assertTrue(searcher.validate("Java is the most popular language"));
    }

    @Test
    public void whenStringContainsJavaScriptThenFalse() {
        StringSearcher searcher = new StringSearcher();
        assertFalse(searcher.validate(
                "Java script can maintain all the arithmetical operations correctly"));
    }

    /**
     * Parser
     */
    @Test
    public void whenParseSiteThenParsed() {
        Parser parser = new Parser();
        List<ParsedRow> topics = new LinkedList<>();
        topics.addAll(parser.get(2));
        for (ParsedRow row : topics) {
            System.out.println(row.getTitle());
            System.out.println(row.getUrl());
            System.out.println(row.getDate());
            System.out.println();
        }
        System.out.println(topics.size());
    }

    /**
     * Collector test
     */
    @Test
    public void whenGetRowsThenOnlyValidVacancies() {
        ParsedRow validRow = new ParsedRow("Java developer", "www.site.com", 1);
        ParsedRow incorrectRow = new ParsedRow("Fortran developer", "www.site.com", 2);
        List<ParsedRow> rows = new ArrayList<>();
        rows.add(validRow);
        rows.add(incorrectRow);
        Collector collector = new Collector(rows);
        List<ParsedRow> validTopics = collector.getOutput();
        assertThat(validTopics.size(), is(1));
    }

    /**
     * Connector test
     */

    @Test
    public void whenConnectToDbThenConnected() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/main/resources/SqlParser.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        DbConnector connector = new DbConnector(properties);
        assertTrue(connector.setUp());
    }

    @Test
    public void whenCheckDatabaseThenGetSomeResults() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/main/resources/SqlParser.properties"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        DbConnector connector = new DbConnector(properties);
        connector.setUp();
        List<String> result = new LinkedList<>();
        result = connector.checkDB();
        System.out.println(result);
    }

    /**
     * Date counter test
     */
    @Test
    public void whenGetDateThenGotIsDateNewEnough() {
        DateCounter counter = new DateCounter();
        ParsedRow row = new ParsedRow("Test", "test.com", System.currentTimeMillis());
        assertTrue(counter.fromBeginOfThisYear(row));
    }
}