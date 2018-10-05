package com.weaverplatform.postgresql.database.write;

import com.weaverplatform.postgresql.database.exceptions.WeaverDatabaseException;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * @author Mohamad Alamili
 */
public interface WriteStatement {

  Calendar UTC_CALENDAR = Calendar.getInstance(TimeZone.getTimeZone("UTC"));

  String getUpdateQuery();

  void addToBatch(PreparedStatement statement) throws SQLException, WeaverDatabaseException;
}
