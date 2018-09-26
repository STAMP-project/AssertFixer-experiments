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
import com.github.yonatankahana.sylvester.twitter.api.search.status.Hashtag;
import com.github.yonatankahana.sylvester.twitter.api.search.status.Or;
import com.github.yonatankahana.sylvester.twitter.api.search.status.StatusSearch;
import com.github.yonatankahana.sylvester.twitter.api.search.status.StatusSearchCondition;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.TwitterException;

/**
 *
 * @author Yonatan Kahana <yonatankahana.il@gmail.com> and Dan Elkis <speakupness@gmail.com>
 */
public class BirthdayBlowout implements Plugin{
    
    private Cron cron;
    private TwitterClient client;
    private final int dailyCapacity; // Beware you might get blocked or assassinated.
    private final DBContext dBContext;
    
    
    public BirthdayBlowout(Cron cron, TwitterClient client, int cap, DBContext dBContext) {
        this.cron = cron;
        this.client = client;
        this.dailyCapacity = cap;
        this.dBContext = dBContext;
    }

    @Override
    public String getPluginName() {
        return "Birthday Blowout.";
    }

    @Override
    public String getPluginVersion() {
        return "1.0";
    }

    @Override
    public String getPluginUID() {
        return "kael.plugin.birthdayblowout";
    }

    @Override
    public String getPluginDescription() {
        return "Likes random birthday tweets.";
    }

    @Override
    public void onPluginLoaded() throws PluginException {
        PeriodicalTask task = new PeriodicalTask() {
            @Override
            public List<Period> repeatEvery() {
                List<Period> periods = new ArrayList<>();
                periods.add(Period.ofDays(1));
                return periods; 
            }

            @Override
            public boolean isLimitedRepeats() {
                return false;
            }

            @Override
            public int maximumRepeats() {
                return -1;
            }

            @Override
            public void execute() {
                try {
                    _execute();
                } catch (DatabaseException ex) {
                    Logger.getLogger(BirthdayBlowout.class.getName()).log(Level.SEVERE, null, ex);
                }
            }


        };
        
        cron.schedule(task);
    }

    @Override
    public void onPluginUnloaded() {
        System.out.println("Birthday Blowout Done.");
    }
    
    private void _execute() throws DatabaseException {
        try {
            StatusSearchCondition[] conditions = new StatusSearchCondition[]{
                new Or("#bday", "#bdaygirl", "#birthday", "#HBD", "#HappyBirthday", "\"Happy Birthday\"")
            };
            QueryResult result = client.search(new StatusSearch(conditions).query());
            Table table = dBContext.getTable(this);
            for (int i = 0; i < (Integer) table.getOrDefault("dailyCapacity", dailyCapacity);i++) {
                client.favorite(result.getTweets().get(i).getId());
                System.out.println("LIKED: " + result.getTweets().get(i).getId());
            }

        } catch (TwitterException ex) {
            Logger.getLogger(BirthdayBlowout.class.getName()).log(Level.SEVERE, null, ex);
        }    }

    @Override
    public List<String> urls() {
        return new ArrayList<>();
    }

    @Override
    public String getOwnershipInformation() {
        return "kael";
    }

    @Override
    public void onEvent(Event event) throws PluginException {
        // Not interested in any events.
    }
    
    
    
}
