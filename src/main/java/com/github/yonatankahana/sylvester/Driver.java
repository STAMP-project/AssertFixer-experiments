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
package com.github.yonatankahana.sylvester;

import com.github.yonatankahana.sylvester.core.Plugin;
import com.github.yonatankahana.sylvester.core.PluginException;
import com.github.yonatankahana.sylvester.cotext.APIContext;
import com.github.yonatankahana.sylvester.cotext.CronContext;
import com.github.yonatankahana.sylvester.cotext.DBContext;
import com.github.yonatankahana.sylvester.cotext.EventContext;
import com.github.yonatankahana.sylvester.db.DatabaseException;
import com.github.yonatankahana.sylvester.twitter.TwitterClient;
import com.github.yonatankahana.sylvester.twitter.TwitterClientImpl;
import com.github.yonatankahana.sylvester.twitter.TwitterCredentials;
import com.github.yonatankahana.sylvester.twitter.TwitterSession;
import com.github.yonatankahana.sylvester.twitter.plugins.BirthdayBlowout;
import com.github.yonatankahana.sylvester.twitter.plugins.InstaUnfollowPluginFactory;
import java.util.HashMap;
import twitter4j.TwitterException;

/**
 *
 * @author Yonatan Kahana <yonatankahana.il@gmail.com>
 */
public class Driver {

    public static void main(String[] args) throws TwitterException, PluginException, DatabaseException {
        OAuthCredentials credentials
                = null;

        TwitterSession session = new TwitterSession(credentials);
        TwitterClient twitterClient = new TwitterClientImpl(session);

        // Create all the contexts
        HashMap<String, Client> clients = new HashMap<>();
        clients.put("twitter", twitterClient);
        APIContext apiContext = new APIContext(clients);
        EventContext eventContext = new EventContext();
        CronContext cronContext = new CronContext();
        DBContext dbContext = new DBContext();

        eventContext.register(cronContext.getCron()); // Cron also listens to events.

        // TODO: Set up the server
        // To be implemented.
        // Load all the plugin factories and feed them with all of the contexts.
        InstaUnfollowPluginFactory iupf = new InstaUnfollowPluginFactory(apiContext, cronContext,
                eventContext, dbContext);

        // Start CRON
        cronContext.start();

        // Start all plugins
//        Plugin plugin = iupf.getPlugin();
        Plugin plugin = new BirthdayBlowout(cronContext.getCron(), twitterClient, 2, dbContext);
        dbContext.getTable(plugin).store("dailyCapacity", 1);
        plugin.onPluginLoaded();

//        dbContext.getTable(plugin).delete("patience");
//        plugin.onPluginLoaded();
    }
}
