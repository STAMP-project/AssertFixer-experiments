package org.dimyriy.vfs.impl.util;

import java.lang.management.ManagementFactory;

/**
 * @author Dmitrii Bogdanov
 * Created at 23.09.18
 */
public final class SystemUtil {
  private SystemUtil() {
  }

  public static int getCurrentProcessPid() {
    final String name = ManagementFactory.getRuntimeMXBean().getName();
    return Integer.valueOf(name.substring(0, name.indexOf('@')));
  }

  public static long currentTS() {
    return System.currentTimeMillis();
  }
}
