package com.github.yonatankahana.sylvester.cotext;

import com.github.yonatankahana.sylvester.core.Plugin;
import com.github.yonatankahana.sylvester.db.Database;
import com.github.yonatankahana.sylvester.db.DatabaseException;
import com.github.yonatankahana.sylvester.db.FileDatabase;
import com.github.yonatankahana.sylvester.db.InMemoryDatabase;
import com.github.yonatankahana.sylvester.db.Table;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author d-kiss (http://www.github.com/d-kiss)
 */
public class DBContext {

    final private Database database;

    public DBContext() {
        this(new FileDatabase(new File("development.db")));
    }

    public DBContext(Database database) {
        this.database = database;
    }

    public Table getTable(Plugin plugin) throws DatabaseException {
        return database.getTable(plugin);
    }
}
