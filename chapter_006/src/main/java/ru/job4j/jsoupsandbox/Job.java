package ru.job4j.jsoupsandbox;


import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class Job implements org.quartz.Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("run.");
    }
}
