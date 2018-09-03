package ru.job4j.jobparser;

import org.apache.log4j.Logger;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class ScheduleParser {
    static Properties properties = new Properties();
    final static Logger LOG = Logger.getLogger(Start.class);
    public static void main(String[] args) {
        LOG.info("Starting application...");
        try (FileInputStream fileInputStream = new FileInputStream(args[0])) {
            properties.load(fileInputStream);
        } catch (FileNotFoundException fe) {
            LOG.error(fe.getMessage(), fe);
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
        try {
            JobDetail job = newJob(Start.class)
                    .withIdentity("job1", "group1")
                    .build();
            Trigger trigger = newTrigger()
                    .withIdentity("Trigger1", "group1")
                    .withSchedule(CronScheduleBuilder.cronSchedule(properties.getProperty("time")))
                    .build();
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();
            scheduler.scheduleJob(job, trigger);
        } catch (SchedulerException e) {
            LOG.error(e.getMessage(), e);
        }
        LOG.info("Trigged...");
    }

    public static Properties getProperty() {
        return properties;
    }
}
