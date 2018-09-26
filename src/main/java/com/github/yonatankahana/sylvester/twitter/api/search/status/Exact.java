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
public class Exact implements StatusSearchCondition {

    final String _text;

    public Exact(String _text) {
        this._text = _text;
    }

    @Override
    public Query toQuery() {
        return new Query(_text);
    }

}
