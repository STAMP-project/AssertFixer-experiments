package com.weaverplatform.postgresql.util;

import org.junit.Test;

import java.sql.Timestamp;

import static org.junit.Assert.assertEquals;

public class DateTimeParserTest {


  @Test
  public void testObjectParser() {
    assertEquals(new Timestamp(0l), DateTimeParser.getUTCTimestamp(0l));
    assertEquals(new Timestamp(0l), DateTimeParser.getUTCTimestamp(new Long(0l)));
    assertEquals(new Timestamp(4l), DateTimeParser.getUTCTimestamp(4.3d));
    assertEquals(new Timestamp(5l), DateTimeParser.getUTCTimestamp(4.7d));
    assertEquals(new Timestamp(5l), DateTimeParser.getUTCTimestamp(new Double(4.7d)));
  }

  @Test
  public void testStringParser() {
    assertEquals(1483274096120l, DateTimeParser.getUTCTime("2017-01-01T12:34:56.12Z"));
    assertEquals(1483274096123l, DateTimeParser.getUTCTime("2017-01-01T12:34:56.123Z"));
    assertEquals(1483274096000l, DateTimeParser.getUTCTime("2017-01-01 12:34:56Z"));
    assertEquals(1483274096789l, DateTimeParser.getUTCTime("2017-01-01 13:34:56.789 +0100"));
    assertEquals(1483274096789l, DateTimeParser.getUTCTime("2017-01-01 11:34:56.789-0100"));
    assertEquals(1483274096789l, DateTimeParser.getUTCTime("2017-01-01 11:34:56.789-01:00"));
    assertEquals(1483228800000l, DateTimeParser.getUTCTime("2017"));

    assertParserError("21435-12-23-34");
  }

  @Test
  public void testLongParser() {
    assertEquals("2017-01-01T12:34:56.120Z", DateTimeParser.getUTCTime(1483274096120l));
    assertEquals("2017-01-01T12:34:56.123Z", DateTimeParser.getUTCTime(1483274096123l));
    assertEquals("2017-01-01T12:34:56.000Z", DateTimeParser.getUTCTime(1483274096000l));
    assertEquals("2017-01-01T12:34:56.789Z", DateTimeParser.getUTCTime(1483274096789l));
    assertEquals("2017-01-01T12:34:56.789Z", DateTimeParser.getUTCTime(1483274096789l));
    assertEquals("2017-01-01T12:34:56.789Z", DateTimeParser.getUTCTime(1483274096789l));
    assertEquals("2017-01-01T00:00:00.000Z", DateTimeParser.getUTCTime(1483228800000l));
  }



  public static void assertParserError(String value) {
    boolean rightError = false;
    try {
      DateTimeParser.getUTCTimestamp(value);
    } catch(DateTimeParseException e) {
      rightError = true;
    }
    assert(rightError);
  }
}
