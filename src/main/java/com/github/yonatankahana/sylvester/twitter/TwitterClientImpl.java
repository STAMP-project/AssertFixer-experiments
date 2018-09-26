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

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.TwitterException;

/**
 *
 * @author Yonatan Kahana <yonatankahana.il@gmail.com>
 */
public class TwitterClientImpl implements TwitterClient {

    TwitterSession session;

    public TwitterClientImpl(TwitterSession session) {
        this.session = session;
    }

    @Override
    public Status createStatus(String status) throws TwitterException {
        return session.getTwitter().tweets().updateStatus(status);
    }

    @Override
    public Status reTweet(long statusId) throws TwitterException {
        return session.getTwitter().tweets().retweetStatus(statusId);
    }

    @Override
    public Object follow(TwitterUser user) throws TwitterException {
        if (user.getId() != null) {
            return session.getTwitter().createFriendship(user.getId());
        }

        return session.getTwitter().createFriendship(user.getScreenName());
    }

    @Override
    public Object unfollow(TwitterUser user) throws TwitterException {

        if (user.getId() != null) {
            return session.getTwitter().destroyFriendship(user.getId());
        }

        return session.getTwitter().destroyFriendship(user.getScreenName());

    }

    @Override
    public long[] getFollowers(TwitterUser user) throws TwitterException {
        if (user.getId() != null) {
            return session.getTwitter().friendsFollowers().getFriendsIDs(user.getId(), -1).getIDs();
        }

        return session.getTwitter().friendsFollowers().getFriendsIDs(user.getScreenName(), -1).getIDs();
    }

    @Override
    public TwitterUser me() throws TwitterException {
        return new TwitterUser(session.getTwitter().getId());
    }

    @Override
    public int getMyFollowersCount() throws TwitterException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getFollowers(String screenName) throws TwitterException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getFollowersCount(String screenName) throws TwitterException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public QueryResult search(Query query) throws TwitterException {
        return session.getTwitter().search(query);
    }

    @Override
    public void favorite(long statusId) throws TwitterException {
        session.getTwitter().favorites().createFavorite(statusId);
    }

}
