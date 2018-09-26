package com.github.yonatankahana.sylvester.cron;

/**
 *
 * @author d-kiss
 */


public interface RepeatingTask extends Task {
    boolean isLimitedRepeats();
    int maximumRepeats();  // 0 for no maximum.
}
