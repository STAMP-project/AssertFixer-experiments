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
package com.github.yonatankahana.sylvester.twitter;

import com.github.yonatankahana.sylvester.Client;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.TwitterException;

/**
 *
 * @author Yonatan Kahana <yonatankahana.il@gmail.com>
 */
public interface TwitterClient extends Client {
    Status createStatus(String status) throws TwitterException;
    Status reTweet(long statusId) throws TwitterException;
    Object follow(TwitterUser user) throws TwitterException;
    Object unfollow(TwitterUser user) throws TwitterException;
    long[] getFollowers(TwitterUser user) throws TwitterException;
    int getMyFollowersCount() throws TwitterException;
    Object getFollowers(String screenName) throws TwitterException;
    int getFollowersCount(String screenName) throws TwitterException;
    QueryResult search(Query query) throws TwitterException;
    TwitterUser me() throws TwitterException;
    void favorite(long statusId) throws TwitterException;
}
