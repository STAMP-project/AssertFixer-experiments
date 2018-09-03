package ru.job4j.jobparser;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;

import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

public class Start implements org.quartz.Job {
    final static Logger LOG = Logger.getLogger(Start.class);
    private Properties properties = new Properties();

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        this.properties = ScheduleParser.getProperty();
        //Is it OK load properties from a static context?
        DbConnector dbConnector = new DbConnector(properties);
        dbConnector.setUp();
        Parser parser = new Parser();
        List<ParsedRow> parsedRows = new LinkedList<>();
        DateCounter counter = new DateCounter();
        if (dbConnector.checkDB().isEmpty()) {

            int deepingIndex = 0;
            while (true) {
                parsedRows.addAll(parser.get(deepingIndex));
                if (counter.fromBeginOfThisYear(((LinkedList<ParsedRow>) parsedRows).getLast())) {
                    deepingIndex++;
                } else {
                    break;
                }
            }

        } else {
            ParsedRow lastRow = dbConnector.getLastRow();
            int i = 0;
            //don't forget how it works
            //Parser parse one page and compare last parsed row with last row in DB
            // which selected several lines above if new one greater than row from DB
            // it means that there's lots of topics and I need to parse one more page
            do {
                parsedRows.addAll(parser.get(i));
                i++;

            } while (((LinkedList<ParsedRow>) parsedRows).getLast().getDate() > lastRow.getDate());
        }
        Collector collector = new Collector(parsedRows);
        List<ParsedRow> selectedRows = collector.getOutput();
        dbConnector.checkDB();
        dbConnector.insertToDB(selectedRows);
    }
}
