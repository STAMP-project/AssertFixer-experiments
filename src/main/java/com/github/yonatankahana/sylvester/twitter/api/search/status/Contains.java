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
package com.github.yonatankahana.sylvester.twitter.api.search.status;

import twitter4j.Query;

/**
 *
 * @author Yonatan Kahana <yonatankahana.il@gmail.com>
 */
public class Contains implements StatusSearchCondition {

    final String contains;
    final String butNot;

    public Contains(String contains) {
        this(contains, null);
    }

    public Contains(String contains, String butNot) {
        if (contains == null) {
            throw new NullPointerException("contains must not be null");
        }
        
        this.contains = contains;
        this.butNot = butNot;
    }

    @Override
    public Query toQuery() {
        return new Query(
                contains
                + (butNot != null ? (" -" + butNot) : (""))
        );
    }

}
