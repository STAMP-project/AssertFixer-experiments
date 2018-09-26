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
import com.github.yonatankahana.sylvester.twitter.api.search.status.Mood;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author Yonatan Kahana <yonatankahana.il@gmail.com>
 */
public class RetweetByKeyword implements Plugin {

    private static final Logger mLogger = Logger.getLogger(RetweetByKeyword.class);

    final Mood mood;
    final long delay;
    final String[] keywords;

    public RetweetByKeyword(Mood mood, long delay, String[] keywords) {
        this.mood = mood;
        this.delay = delay;
        this.keywords = keywords;
    }

    final @Override
    public String getPluginName() {
        return "Retweet by keywords";
    }

    @Override
    public String getPluginVersion() {
        return "1.0";
    }

    @Override
    public String getPluginUID() {
        return "kael.plugin.retweetByKeywords";
    }

    @Override
    public String getPluginDescription() {
        return "TODO: write description...";
    }

    @Override
    public String getOwnershipInformation() {
        return "Yonatan Kahana <yonatankahana.il@gmail.com>";
    }

    @Override
    public void onPluginLoaded() throws PluginException {
        mLogger.info("Retweets By Keyword plugin loaded!");
    }

    @Override
    public void onPluginUnloaded() {
        mLogger.info("Retweets By Keyword plugin unloaded!");
    }

    @Override
    public void onEvent(Event event) throws PluginException {

    }
    
    @Override
    public List<String> urls() {
        return new ArrayList<String>();
    }
    
}
