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

import com.github.yonatankahana.sylvester.core.Plugin;
import com.github.yonatankahana.sylvester.core.PluginFactory;
import com.github.yonatankahana.sylvester.cotext.APIContext;
import com.github.yonatankahana.sylvester.cotext.CronContext;
import com.github.yonatankahana.sylvester.cotext.DBContext;
import com.github.yonatankahana.sylvester.cotext.EventContext;
import com.github.yonatankahana.sylvester.twitter.api.search.status.EveryMood;

/**
 *
 * @author Yonatan Kahana <yonatankahana.il@gmail.com>
 */
public class RetweetByKeywordPluginFactory extends PluginFactory {

    public RetweetByKeywordPluginFactory(APIContext apiContext, CronContext cronContext, 
                                         EventContext eventContext, DBContext dbContext) {
        super(apiContext, cronContext, eventContext, dbContext);
    }

    @Override
    public Plugin getPlugin() {
        return new RetweetByKeyword(new EveryMood(), 25_200_000L, new String[]{"trump", "bibi", "israel"});
    }

}
