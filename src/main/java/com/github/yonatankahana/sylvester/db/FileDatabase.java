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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yonatan Kahana <yonatankahana.il@gmail.com>
 */
public class FileDatabase extends InMemoryDatabase {

    final File dataFile;
    boolean wasLoaded = false;

    public FileDatabase(File dataFile) {
        this.dataFile = dataFile;
    }

    @Override
    public synchronized boolean has(Plugin plugin, String key) throws DatabaseException {
        reload();
        return super.has(plugin, key);
    }

    @Override
    public synchronized void delete(Plugin plugin, String key) throws DatabaseException {
        reload();
        super.delete(plugin, key);
        save();
    }

    @Override
    public synchronized void store(Plugin plugin, String key, Object value) throws DatabaseException {
        reload();
        super.store(plugin, key, value);
        save();
    }

    @Override
    public synchronized Object get(Plugin plugin, String key) throws DatabaseException {
        reload();

        Object obj = super.get(plugin, key);
        save();
        return obj;
    }

    @Override
    public synchronized void close() throws IOException {
        try {
            reload();
            save();
        } catch (DatabaseException ex) {
            throw new IOException("Could not close file " + dataFile, ex);
        }
        super.close();
    }

    @Override
    public synchronized void destroy(String pluginUID) throws DatabaseException {
        reload();
        super.destroy(pluginUID);
        save();
    }

    @Override
    public synchronized Table getTable(Plugin plugin) throws DatabaseException {
        reload();
        return super.getTable(plugin);
    }

    protected void reload() throws DatabaseException {
        try {
            if (!wasLoaded && dataFile.exists()) {
                ObjectInputStream i = new ObjectInputStream(new FileInputStream(dataFile));
                data.clear();
                data.putAll((Map<String, Object>) i.readObject());
                
                wasLoaded = true;
            }
        } catch (IOException | ClassNotFoundException ex) {
            throw new DatabaseException(ex);
        }

    }

    protected void save() throws DatabaseException {
        try {
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(dataFile, false));
            o.writeObject(data);
            o.close();
        } catch (IOException ex) {
            throw new DatabaseException(ex);
        }
    }
}
