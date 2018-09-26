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
package com.github.yonatankahana.sylvester.core;

import com.github.yonatankahana.sylvester.cotext.APIContext;
import com.github.yonatankahana.sylvester.cotext.CronContext;
import com.github.yonatankahana.sylvester.cotext.DBContext;
import com.github.yonatankahana.sylvester.cotext.EventContext;

/**
 *
 * @author Yonatan Kahana <yonatankahana.il@gmail.com>
 */
public abstract class PluginFactory {
    
    protected final APIContext apiContext;
    protected final CronContext cronContext;
    protected final EventContext eventContext;
    protected final DBContext dbContext;

    public PluginFactory(APIContext apiContext, CronContext cronContext, 
                         EventContext eventContext, DBContext dbContext) {
        this.apiContext = apiContext;
        this.cronContext = cronContext;
        this.eventContext = eventContext;
        this.dbContext = dbContext;
    }
 
    
    
    public abstract Plugin getPlugin();
}
