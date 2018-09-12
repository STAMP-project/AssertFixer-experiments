package com.weaverplatform.postgresql.util;

import com.google.common.io.Resources;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @author Mohamad Alamili
 */
public class Resource {

  public static final String get(String path) {
    try {
      return Resources.toString(Resources.getResource(path), Charset.defaultCharset());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
