package com.github.yonatankahana.sylvester.cotext;

import com.github.yonatankahana.sylvester.Client;
import com.github.yonatankahana.sylvester.twitter.TwitterClient;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author d-kiss (http://www.github.com/d-kiss)
 */


public class APIContext {
    private Map<String, Client> clients;

    public APIContext() {
        this(new HashMap<>());
    }

    public APIContext(Map<String, Client> clients) {
        this.clients = clients;
    }
    
    public TwitterClient twitter() {
        return (TwitterClient) clients.get("twitter");
    }
    
}
