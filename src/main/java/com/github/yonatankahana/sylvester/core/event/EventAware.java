package com.github.yonatankahana.sylvester.core.event;

import com.github.yonatankahana.sylvester.core.Event;
import com.github.yonatankahana.sylvester.core.PluginException;

/**
 *
 * @author d-kiss (http://www.github.com/d-kiss)
 */


public interface EventAware {
    void onEvent(Event event) throws PluginException;
}
