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
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Yonatan Kahana <yonatankahana.il@gmail.com>
 */
public class InMemoryDatabase implements Database {

    protected final Map<String, Object> data = new HashMap<>();

    @Override
    public synchronized Table getTable(Plugin plugin) throws DatabaseException {
        return new Table(this, plugin);
    }

    @Override
    public synchronized void destroy(String pluginUID) throws DatabaseException {
        data.entrySet().removeIf((o) -> o.getKey().startsWith(pluginUID + "."));
    }

    @Override
    public synchronized void close() throws IOException {
    }

    @Override
    public synchronized Object get(Plugin plugin, String key) throws DatabaseException {
        return data.get(pluginKey(plugin, key));
    }

    @Override
    public synchronized void store(Plugin plugin, String key, Object value) throws DatabaseException {
        data.put(pluginKey(plugin, key), value);
    }

    @Override
    public synchronized void delete(Plugin plugin, String key) throws DatabaseException {
        data.remove(pluginKey(plugin, key));
    }

    @Override
    public synchronized boolean has(Plugin plugin, String key) throws DatabaseException {
        return data.containsKey(pluginKey(plugin, key));
    }

    private static String pluginKey(Plugin plugin, String key) {
        return plugin.getPluginUID() + "." + key;
    }

}
