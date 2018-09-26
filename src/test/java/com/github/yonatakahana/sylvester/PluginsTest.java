/*
 *   This file is officially part of project Sylvester - Yonatan Kahana and Dan Elkis 
 *   LICENSE:
 *   This program is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 * 
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 * 
 *   You should have received a copy of the GNU General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.github.yonatakahana.sylvester;

import com.github.yonatankahana.sylvester.Client;
import com.github.yonatankahana.sylvester.OAuthCredentials;
import com.github.yonatankahana.sylvester.core.Plugin;
import com.github.yonatankahana.sylvester.core.PluginException;
import com.github.yonatankahana.sylvester.cotext.APIContext;
import com.github.yonatankahana.sylvester.cotext.CronContext;
import com.github.yonatankahana.sylvester.cotext.DBContext;
import com.github.yonatankahana.sylvester.cotext.EventContext;
import com.github.yonatankahana.sylvester.twitter.TwitterClient;
import com.github.yonatankahana.sylvester.twitter.TwitterClientImpl;
import com.github.yonatankahana.sylvester.twitter.TwitterCredentials;
import com.github.yonatankahana.sylvester.twitter.TwitterSession;
import com.github.yonatankahana.sylvester.twitter.TwitterUser;
import com.github.yonatankahana.sylvester.twitter.plugins.InstaUnfollowPlugin;
import com.github.yonatankahana.sylvester.twitter.plugins.InstaUnfollowPluginFactory;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import twitter4j.TwitterException;

/**
 *
 * @author Yonatan Kahana <yonatankahana.il@gmail.com>
 */
public class PluginsTest {

    public APIContext api() throws IOException {
        List<String> keys = Files.readAllLines(Paths.get(new File(".secret").toURI()), StandardCharsets.UTF_8);
        OAuthCredentials credentials = new TwitterCredentials(keys.get(0), keys.get(1),
                keys.get(2), keys.get(3));
        TwitterSession session = new TwitterSession(credentials);
        TwitterClient twitterClient = new TwitterClientImpl(session);

        HashMap<String, Client> clients = new HashMap<>();
        clients.put("twitter", twitterClient);
        APIContext apiContext = new APIContext(clients);
        return apiContext;
    }

    @Test
    public void testInstaUnfollowPlugin() throws IOException, PluginException, TwitterException, InterruptedException {
        
        CronContext cron = new CronContext();
        InstaUnfollowPluginFactory iupf = new InstaUnfollowPluginFactory(api(),
                cron, new EventContext(), new DBContext());
        InstaUnfollowPlugin plugin = (InstaUnfollowPlugin) iupf.getPlugin();
        TwitterClient client = api().twitter();
         
        cron.start();
        client.follow(new TwitterUser("joaquinshaki"));
        plugin.onPluginLoaded();
        Thread.sleep(120000000000000L);


        int amountOfFollowers = client.getFollowers(client.me()).length;
        Assert.assertEquals("You are following " + amountOfFollowers + " people.",
                0, amountOfFollowers);
    }
}
