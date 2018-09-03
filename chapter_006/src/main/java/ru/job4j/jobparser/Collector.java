package ru.job4j.jobparser;

import org.apache.log4j.Logger;

import java.util.*;

/**
 * This class takes array list of all vacancies and returns only valid vacancies
 */
public class Collector {
    final static Logger LOG = Logger.getLogger(Collector.class);

    private List<ParsedRow> input = new ArrayList<>();

    public List<ParsedRow> getOutput() {
        LOG.info("Valid result has sorted.");
        this.selectVacations();
        return output;
    }

    private List<ParsedRow> output = new ArrayList<>();

    public Collector(List<ParsedRow> input) {
        this.input = input;
    }

    private void selectVacations() {
        ParsedRow row = null;
        StringSearcher searcher = new StringSearcher();
        ListIterator<ParsedRow> listIterator = input.listIterator();
        while (listIterator.hasNext()) {
            row = listIterator.next();
            if (!searcher.validate(row.getTitle())) {
                listIterator.remove();
            }
        }
        output.addAll(deleteDuplicates(input));
    }

    //I created TreeMap just to delete duplicates and then put it back to list
    private List<ParsedRow> deleteDuplicates(List<ParsedRow> input) {
        List<ParsedRow> result = new LinkedList<>();
        Map<String, ParsedRow> map = new TreeMap<>();
        for (ParsedRow row : input) {
            map.put(row.getUrl(), row);
        }
        for (Map.Entry<String, ParsedRow> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        LOG.info("Duplicate results has been deleted...");
        return result;
    }

}
