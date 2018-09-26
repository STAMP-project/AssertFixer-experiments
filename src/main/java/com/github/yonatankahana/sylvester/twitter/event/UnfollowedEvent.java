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
package com.github.yonatankahana.sylvester.twitter.event;

import com.github.yonatankahana.sylvester.core.Console;
import com.github.yonatankahana.sylvester.twitter.TwitterClient;
import com.github.yonatankahana.sylvester.twitter.TwitterEvent;

/**
 *
 * @author Yonatan Kahana <yonatankahana.il@gmail.com>
 */
public class UnfollowedEvent extends TwitterEvent {

    final String screenName;

    public UnfollowedEvent(Console console, TwitterClient twitterClient, String screenName) {
        super(console, twitterClient);
        this.screenName = screenName;
    }

    public String getScreenName() {
        return screenName;
    }

    @Override
    public String eventName() {
        return "twitter.unfollowed";
    }

}
