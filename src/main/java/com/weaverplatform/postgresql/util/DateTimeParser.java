package com.weaverplatform.postgresql.util;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import java.sql.Timestamp;

/**
 * This class is used to parse attribute values to timestamp
 * 
 * @author bastbijl
 *
 */
public class DateTimeParser {

  public static Timestamp getUTCTimestamp(Object value) {

    if(value instanceof String) {
      return new Timestamp(getUTCTime((String) value));
    }

    if(value instanceof Long) {
      return new Timestamp((long) value);
    }

    if(value instanceof Double) {
      return new Timestamp(Math.round((double) value));
    }

    throw new DateTimeParseException("Can not interpret the date time value of an object of type " + value.getClass().getSimpleName());
  }

  public static long getUTCTime(String value) {

    DateTimeFormatter XML_DATE_TIME_FORMAT = ISODateTimeFormat.dateTimeParser().withZone(DateTimeZone.UTC);

    DateTime dateTime;

    value = value.replaceFirst(" ", "T");
    value = value.replace(" ", "");

    try {
      dateTime = XML_DATE_TIME_FORMAT.parseDateTime(value);
    } catch (IllegalArgumentException e) {
      throw new DateTimeParseException("Can not parse the value of this string to a timestamp: " + value);
    }

    return dateTime.getMillis();
  }

  public static String getUTCTime(long value) {

    DateTimeFormatter CHECKING_FORMAT = ISODateTimeFormat.dateTime().withZone(DateTimeZone.UTC);

    DateTime dateTime = new DateTime(value);
    return CHECKING_FORMAT.print(dateTime);
  }
}
