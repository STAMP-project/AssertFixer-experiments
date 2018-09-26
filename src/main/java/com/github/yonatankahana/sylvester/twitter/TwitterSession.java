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

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
import com.github.yonatankahana.sylvester.OAuthCredentials;

/**
 *
 * @author Yonatan Kahana <yonatankahana.il@gmail.com>
 */
public class TwitterSession implements TwitterFactory0 {

    final OAuthCredentials credentials;
    transient Twitter _twitter = null;

    public TwitterSession(OAuthCredentials credentials) {
        this.credentials = credentials;
    }

    @Override
    public Twitter getTwitter() {
        if (_twitter == null) {
            ConfigurationBuilder cb = new ConfigurationBuilder();
            cb.setDebugEnabled(true)
//                    .setRestBaseURL("http://twitsandbox.com/")
                    .setOAuthConsumerKey(credentials.getOAuthConsumerKey())
                    .setOAuthConsumerSecret(credentials.getOAuthConsumerSecret())
                    .setOAuthAccessToken(credentials.getOAuthAccessToken())
                    .setOAuthAccessTokenSecret(credentials.getOAuthAccessTokenSecret());
            TwitterFactory tf = new TwitterFactory(cb.build());
            _twitter = tf.getInstance();
        }

        return _twitter;
    }
}
