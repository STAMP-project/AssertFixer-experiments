package com.weaverplatform.postgresql.database.exceptions;

public class WeaverDatabaseException extends Exception {

  private int code;

  public WeaverDatabaseException(int code, String message) {
    super(message);
    this.code = code;
  }

  public WeaverDatabaseException(int code, String message, Throwable cause) {
    super(message, cause);
    this.code = code;
  }
}
