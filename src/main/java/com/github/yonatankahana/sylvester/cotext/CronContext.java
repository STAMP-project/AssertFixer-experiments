package com.github.yonatankahana.sylvester.cotext;

import com.github.yonatankahana.sylvester.cron.Cron;
import com.github.yonatankahana.sylvester.cron.SimpleCronImpl;
import com.github.yonatankahana.sylvester.cron.Task;

/**
 *
 * @author d-kiss (http://www.github.com/d-kiss)
 */


public class CronContext {
    private Cron cron;
    
    public CronContext() { 
        this(new SimpleCronImpl());
    }
    
    public CronContext(Cron cron) {
        this.cron = cron;
    }
    
    public void scheduleJob(Task task) {
        cron.schedule(task);
    }
    
    public void cancelJob(Task task) {
        cron.cancel(task);
    }
    
    public Cron getCron() {
        return cron;
    }
    
    public void start() {
        cron.start();
    }
    
}
