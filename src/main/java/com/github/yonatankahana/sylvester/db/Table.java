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
package com.github.yonatankahana.sylvester.db;

import com.github.yonatankahana.sylvester.core.Plugin;

/**
 *
 * @author Yonatan Kahana <yonatankahana.il@gmail.com>
 */
public final class Table {

    private final Database database;
    private final Plugin plugin;

    public Table(Database database, Plugin plugin) {
        this.database = database;
        this.plugin = plugin;
    }
    
   public Object get(String key) throws DatabaseException {
       return database.get(plugin, key);
   }
   
   public Object getOrDefault(String key, Object def) throws DatabaseException {
       if (!has(key)) {
           return def;
       }
       
       return get(key);
   }

   public  <T> T get(String key, Class<T> clazz) throws DatabaseException {
       return (T) get(key);
   }

   public void store(String key, Object value) throws DatabaseException {
       database.store(plugin, key, value);
   }

   public  void delete(String key) throws DatabaseException {
       database.delete(plugin, key);
   }

   public boolean has(String key) throws DatabaseException {
      return database.has(plugin, key);
   }


    public void destroy() throws DatabaseException {
        database.destroy(plugin.getPluginUID());
    }
}
