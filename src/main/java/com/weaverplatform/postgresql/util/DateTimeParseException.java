package com.weaverplatform.postgresql.util;

/**
 * @author bastbijl, Sysunite 2017
 */
public class DateTimeParseException extends RuntimeException {
  public DateTimeParseException() {
    super();
  }
  public DateTimeParseException(String message) {
    super(message);
  }
}
