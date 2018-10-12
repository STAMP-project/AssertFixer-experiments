// code by jph
package ch.ethz.idsc.gokart.gui;

import java.util.Arrays;
import java.util.List;

import ch.ethz.idsc.gokart.core.AutoboxSocketModule;
import ch.ethz.idsc.gokart.core.fuse.AutonomySafetyModule;
import ch.ethz.idsc.gokart.core.fuse.DavisImuTrackerModule;
import ch.ethz.idsc.gokart.core.fuse.LinmotSafetyModule;
import ch.ethz.idsc.gokart.core.fuse.MiscEmergencyWatchdog;
import ch.ethz.idsc.gokart.core.fuse.SteerCalibrationWatchdog;
import ch.ethz.idsc.gokart.core.fuse.Vlp16PassiveSlowing;
import ch.ethz.idsc.gokart.core.joy.GenericXboxPadLcmServerModule;
import ch.ethz.idsc.gokart.core.joy.JoystickResetModule;
import ch.ethz.idsc.gokart.core.pos.GokartPoseLcmModule;
import ch.ethz.idsc.gokart.core.slam.LidarLocalizationModule;
import ch.ethz.idsc.gokart.lcm.mod.AutoboxLcmServerModule;
import ch.ethz.idsc.gokart.lcm.mod.Vlp16LcmServerModule;
import ch.ethz.idsc.retina.sys.LoggerModule;
import ch.ethz.idsc.retina.sys.ModuleAuto;
import junit.framework.TestCase;

public class RunTabbedTaskGuiTest extends TestCase {
  public void testSimple() {
    assertTrue(RunTabbedTaskGui.MODULES_DEV.contains(SteerCalibrationWatchdog.class));
    assertTrue(RunTabbedTaskGui.MODULES_DEV.contains(MiscEmergencyWatchdog.class));
  }

  public void testAutStartStop() throws Exception {
    for (Class<?> module : RunTabbedTaskGui.MODULES_AUT) {
      ModuleAuto.INSTANCE.runOne(module);
      Thread.sleep(100);
      ModuleAuto.INSTANCE.terminateOne(module);
    }
  }

  public void testAutonomousSafety() {
    List<Class<?>> list = Arrays.asList( //
        AutoboxSocketModule.class, //
        Vlp16LcmServerModule.class, //
        AutoboxLcmServerModule.class, //
        GokartStatusLcmModule.class, //
        GokartPoseLcmModule.class, //
        LoggerModule.class, //
        GenericXboxPadLcmServerModule.class, //
        SteerCalibrationWatchdog.class, //
        MiscEmergencyWatchdog.class, //
        Vlp16PassiveSlowing.class, //
        LidarLocalizationModule.class, //
        LinmotSafetyModule.class, //
        JoystickResetModule.class, //
        DavisImuTrackerModule.class, //
        AutonomySafetyModule.class //
    );
    for (Class<?> cls : list)
      assertTrue(RunTabbedTaskGui.MODULES_DEV.contains(cls));
  }
}
