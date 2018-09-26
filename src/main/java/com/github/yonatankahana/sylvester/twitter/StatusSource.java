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

import java.util.Iterator;
import java.util.List;
import twitter4j.Status;
import twitter4j.TwitterException;

/**
 *
 * @author Yonatan Kahana <yonatankahana.il@gmail.com>
 */
public interface StatusSource {
    List<Status> getAll() throws TwitterException;
    Status getFirst() throws TwitterException;
    boolean isAny() throws TwitterException;
    void eager() throws TwitterException;
    Iterator<Status> iterator() throws TwitterException;
}
