package com.diffblue.deeptestutils;

// Copyright 2016-2018 Diffblue limited. All rights reserved.

/**
 * <code>DeeptestUtilsException</code> is used to wrap other exceptions
 * thrown from Deeptestutils that are not directly required for
 * the test.
 *
 * @author <a href="http://diffblue.com">Diffblue</a>
 */
public class DeeptestUtilsException extends RuntimeException {
  /**
   * Creates a new <code>DeeptestUtilsException</code> instance with
   * message only.
   *
   * @param errorMsg Represents the error message.
   */
  DeeptestUtilsException(final String errorMsg) {
    super(errorMsg);
  }

  /**
   * Creates a new <code>DeeptestUtilsException</code> instance with
   * message and cause.
   *
   * @param errorMsg Represents the error message. It contains the field
   * in question, the expected value and the actual value.
   * @param cause Represents the original exception.
   */
  DeeptestUtilsException(final String errorMsg, final Throwable cause) {
    super(errorMsg, cause);
  }
}
