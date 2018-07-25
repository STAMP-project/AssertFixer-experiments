package io.symonk.sylenium;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Optional;

/** @author SimonK */
@Slf4j
public class SyConfig {

  private static final String SYLENIUM_WAIT = "sylenium.wait";
  private static final String SYLENIUM_POLL = "sylenium.poll";

  /**
   * Explicit wait for predicaments, will wait for verification of webelement state for this amount of time.
   * By default, explicit wait is 10 seconds, time should be provided in milliseconds
   */
  public static long $wait = parseLongFromSystemPropertyString(SYLENIUM_WAIT, "5000");


  /**
   * Polling interval to run against predicaments
   * By default, polling occurrs every 100 milliseconds
   */
  public static long $poll = parseLongFromSystemPropertyString(SYLENIUM_POLL, "100");


  public static void rebuildConfiguration() {
    $wait = parseLongFromSystemPropertyString(SYLENIUM_WAIT, "5000");
    $poll = parseLongFromSystemPropertyString(SYLENIUM_POLL, "100");
  }


  private static Long parseLongFromSystemPropertyString(final String propertyKey, final String defaultValue) {
    return Long.parseLong(System.getProperty(propertyKey, defaultValue));
  }

}
