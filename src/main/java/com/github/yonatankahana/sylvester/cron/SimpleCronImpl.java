package com.github.yonatankahana.sylvester.cron;

import com.github.yonatankahana.sylvester.core.Event;
import com.github.yonatankahana.sylvester.core.PluginException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author d-kiss (http://www.github.com/d-kiss)
 */
/**
 * This class is a simple worker pool; it does nothing too sophisticated. only
 * exists to allow rapid development of features outside the core and test
 * existing system design.
 */
public class SimpleCronImpl implements Cron {

    private final ArrayList<Task> tasks;
    private int currentTaskIndex;
    Thread thread;

    public SimpleCronImpl() {
        this(new ArrayList<Task>());
    }

    public SimpleCronImpl(ArrayList<Task> tasks) {
        this.tasks = tasks;
        this.currentTaskIndex = 0;
    }

    /**
     * Iterate all tasks in a different thread. Once again, a very stupid
     * implementation that should just work.
     */
    @Override
    public void start() {
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    tasks.forEach((task) -> {
                        runTask(task);
                    });
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(SimpleCronImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        });
        thread.start();
    }

    @Override
    public boolean schedule(Task cronTask) {
        tasks.add(cronTask);
        return true;
    }

    @Override
    public boolean cancel(Task cronTask) {
        tasks.remove(cronTask);
        return true;
    }

    @Override
    public List<Task> tasks() {
        return tasks;
    }

    @Override
    public Task next() {
        return tasks.get(currentTaskIndex);
    }

    @Override
    public boolean hasNext() {
        return tasks.size() > currentTaskIndex;
    }

    /**
     * For each task saved, if it's triggered by any event, run the task.
     *
     * @param event: event raised.
     * @throws PluginException: meow?
     */
    @Override
    public void onEvent(Event event) throws PluginException {
        synchronized (tasks) {
            for (Task task : tasks) {
                if (task instanceof OnEventTask) {
                    for (Event triggeredBy : ((OnEventTask) task).triggers()) {
                        if (event.getClass().equals(triggeredBy.getClass())) {
                            runTask(task);
                        }
                    }
                }
            }
        }
    }

    private void runTask(Task task) {
        task.execute();
    }

}
