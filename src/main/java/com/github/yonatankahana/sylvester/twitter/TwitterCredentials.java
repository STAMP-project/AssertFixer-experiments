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

import com.github.yonatankahana.sylvester.OAuthCredentials;

/**
 *
 * @author Yonatan Kahana <yonatankahana.il@gmail.com>
 */
public class TwitterCredentials implements OAuthCredentials {

    final String consumerKey;
    final String consumerSecret;
    final String accessToken;
    final String accessTokenSecret;

    public TwitterCredentials(String consumerKey, String consumerSecret, String accessToken, String accessTokenSecret) {
        this.consumerKey = consumerKey;
        this.consumerSecret = consumerSecret;
        this.accessToken = accessToken;
        this.accessTokenSecret = accessTokenSecret;
    }

    @Override
    public String getOAuthConsumerKey() {
        return consumerKey;
    }

    @Override
    public String getOAuthConsumerSecret() {
        return consumerSecret;
    }

    @Override
    public String getOAuthAccessToken() {
        return accessToken;
    }

    @Override
    public String getOAuthAccessTokenSecret() {
        return accessTokenSecret;
    }

}
