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
package com.github.yonatankahana.sylvester.twitter.plugins;

import com.github.yonatankahana.sylvester.core.Event;
import com.github.yonatankahana.sylvester.core.Plugin;
import com.github.yonatankahana.sylvester.core.PluginException;
import com.github.yonatankahana.sylvester.cotext.DBContext;
import com.github.yonatankahana.sylvester.cron.Cron;
import com.github.yonatankahana.sylvester.cron.PeriodicalTask;
import com.github.yonatankahana.sylvester.db.DatabaseException;
import com.github.yonatankahana.sylvester.db.Table;
import com.github.yonatankahana.sylvester.twitter.TwitterClient;
import com.github.yonatankahana.sylvester.twitter.TwitterUser;
import java.time.Period;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.TwitterException;

/**
 *
 * @author Yonatan Kahana <yonatankahana.il@gmail.com>
 */
public class InstaUnfollowPlugin implements Plugin {

    private final long patience; // In Milliseconds.
    private final String[] screenNamesWhitelist;
    private final long runEvery;
    private final TwitterClient client;
    private final Cron cron;
    private final DBContext dbContext;

    public InstaUnfollowPlugin(long patience, String[] screenNamesWhitelist,
            long runEvery, TwitterClient client, Cron cron, DBContext dbContext) {
        this.patience = patience;
        this.screenNamesWhitelist = screenNamesWhitelist;
        this.runEvery = runEvery;
        this.client = client;
        this.cron = cron;
        this.dbContext = dbContext;
    }

    @Override
    public String getPluginName() {
        return "Instaunfollow Plugin";
    }

    @Override
    public String getPluginVersion() {
        return "1.0";
    }

    @Override
    public String getPluginUID() {
        return "kael.plugin.instaunfollow";
    }

    @Override
    public String getPluginDescription() {
        return "Unfollow twitter users that are not following you back";
    }

    @Override
    public void onPluginLoaded() throws PluginException {
        // Get all people i follow screen names

        PeriodicalTask task = new PeriodicalTask() {
            @Override
            public List<Period> repeatEvery() {
                List<Period> periods = new ArrayList<>();
                periods.add(Period.ofDays(1));
                return periods;
            }

            @Override
            public boolean isLimitedRepeats() {
                return true;
            }

            @Override
            public int maximumRepeats() {
                return 1;
            }

            @Override
            public void execute() {

                try {
                    _execute();
                } catch (TwitterException ex) {
                    // Just log the message for now.
                    Logger.getLogger(InstaUnfollowPlugin.class.getName()).log(Level.INFO, ex.getErrorMessage());
                } catch (DatabaseException ex) {
                    Logger.getLogger(InstaUnfollowPlugin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        };

        cron.schedule(task);

    }

    public void _execute() throws TwitterException, DatabaseException {
        long[] myFollowers = client.getFollowers(client.me());
        Table table = dbContext.getTable(this);

        for (Long id : myFollowers) {
            if (timeSinceFollowed(id) > (Long) table.getOrDefault("patience", patience)) {
                client.unfollow(new TwitterUser(id));
                table.delete(id.toString());
                System.out.println("Unfollowed (id=" + id + ")");
            }
        }
    }

    @Override
    public void onPluginUnloaded() {
        System.out.println("Meow.");
    }

    @Override
    public void onEvent(Event event) throws PluginException {
        // Catch unfollowed
    }

    @Override
    public String getOwnershipInformation() {
        return "kael";
    }

    public long timeSinceFollowed(Long id) throws DatabaseException {
        Table table = dbContext.getTable(this);
        if (!table.has(id.toString())) {
            table.store(id.toString(), new Date());
        }
        Date lastPoll = table.get(id.toString(), Date.class);
        Date now = new Date();
        return now.getTime() - lastPoll.getTime();
    }

    @Override
    public List<String> urls() {
        return new ArrayList<String>();  // Currently no URLs.
    }

}
