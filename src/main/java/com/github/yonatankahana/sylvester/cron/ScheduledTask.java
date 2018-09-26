package com.github.yonatankahana.sylvester.cron;

import java.util.Date;
import java.util.List;

/**
 *
 * @author d-kiss
 */


public interface ScheduledTask extends RepeatingTask {
    List<Date> dueTo();
}
