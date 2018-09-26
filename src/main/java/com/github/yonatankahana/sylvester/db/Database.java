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
import java.io.Closeable;
import java.util.List;

/**
 *
 * @author Yonatan Kahana <yonatankahana.il@gmail.com>
 */
public interface Database extends Closeable {

    Table getTable(Plugin plugin) throws DatabaseException;

    void destroy(String tableName) throws DatabaseException;

    Object get(Plugin plugin, String key) throws DatabaseException;

    void store(Plugin plugin, String key, Object value) throws DatabaseException;

    void delete(Plugin plugin, String key) throws DatabaseException;

    boolean has(Plugin plugin, String key) throws DatabaseException;
}
