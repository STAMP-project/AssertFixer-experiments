package com.weaverplatform.postgresql.util;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * This class is used to generate UTC date objects for java.sql.Timestamp's.
 * 
 * @author alex
 *
 */
public class UTCTimestamp {

  public static final Calendar UTC_CALENDAR = Calendar.getInstance(TimeZone.getTimeZone("UTC"));

  public static Date getDate(Timestamp timestamp) {
    if (timestamp == null) {
      return null;
    }

    Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
    cal.setTimeInMillis(timestamp.getTime());
    return cal.getTime();
  }
  
  public static long getTime(Timestamp timestamp) {
    return getDate(timestamp).getTime();
  }

}
