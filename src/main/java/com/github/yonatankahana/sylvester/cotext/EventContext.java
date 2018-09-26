package com.github.yonatankahana.sylvester.cotext;

import com.github.yonatankahana.sylvester.core.Event;
import com.github.yonatankahana.sylvester.core.Plugin;
import com.github.yonatankahana.sylvester.core.PluginException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.github.yonatankahana.sylvester.core.event.EventAware;

/**
 *
 * @author d-kiss (http://www.github.com/d-kiss)
 */


public class EventContext {
    private ArrayList<EventAware> listeningPlugins;
    
    public EventContext() {
        this(new ArrayList<>());
    }
    
    public EventContext(ArrayList<EventAware> listeningPlugins) {
        this.listeningPlugins = listeningPlugins;
    }
    
    public void broadcast(Event event) {
        listeningPlugins.forEach((plugin) -> {
            try {
                plugin.onEvent(event);
            } catch (PluginException ex) {
                Logger.getLogger(EventContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    public void register(EventAware plugin) {
        listeningPlugins.add(plugin);
    }
    
    public void unregister(EventAware plugin) {
        listeningPlugins.remove(plugin);
    }
    
}
