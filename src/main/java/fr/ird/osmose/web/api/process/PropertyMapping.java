package fr.ird.osmose.web.api.process;

import java.io.IOException;

interface PropertyMapping {
    void forMapping(String tableName, String columnName, String mappedName, String defaultValue) throws IOException;
}
