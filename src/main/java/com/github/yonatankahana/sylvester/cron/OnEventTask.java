package com.github.yonatankahana.sylvester.cron;

import com.github.yonatankahana.sylvester.core.Event;
import java.util.List;

/**
 *
 * @author d-kiss
 */


public interface OnEventTask extends RepeatingTask {
    List<Event> triggers();
}
