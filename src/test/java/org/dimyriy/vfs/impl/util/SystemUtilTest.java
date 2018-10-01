package org.dimyriy.vfs.impl.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.management.ManagementFactory;

/**
 * @author Dmitrii Bogdanov
 * Created at 23.09.18
 */
class SystemUtilTest {

  @Test
  void getCurrentProcessPid_ReturnsSamePidAsManagementBean() {
    Assertions.assertThat(String.valueOf(SystemUtil.getCurrentProcessPid())).isSubstringOf(ManagementFactory.getRuntimeMXBean().getName());
  }
}