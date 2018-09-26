package com.github.yonatankahana.sylvester.cron;

import java.time.Period;
import java.util.List;

/**
 *
 * @author d-kiss
 */


public interface PeriodicalTask extends RepeatingTask {
    List<Period> repeatEvery();
}
