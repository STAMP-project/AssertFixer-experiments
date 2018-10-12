// code by jph
package ch.ethz.idsc.gokart.offline.tab;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

import ch.ethz.idsc.gokart.core.pos.GokartPoseEvent;
import ch.ethz.idsc.gokart.core.pos.GokartPoseHelper;
import ch.ethz.idsc.gokart.gui.GokartLcmChannel;
import ch.ethz.idsc.gokart.offline.api.OfflineTableSupplier;
import ch.ethz.idsc.owl.bot.util.UserHome;
import ch.ethz.idsc.retina.lcm.OfflineLogPlayer;
import ch.ethz.idsc.retina.util.math.Magnitude;
import ch.ethz.idsc.tensor.Scalar;
import ch.ethz.idsc.tensor.Tensor;
import ch.ethz.idsc.tensor.Tensors;
import ch.ethz.idsc.tensor.io.CsvFormat;
import ch.ethz.idsc.tensor.io.Export;
import ch.ethz.idsc.tensor.io.TableBuilder;

public class TimePoseQualityTable implements OfflineTableSupplier {
  private final TableBuilder tableBuilder = new TableBuilder();
  private Tensor last = Tensors.empty();

  @Override // from OfflineLogListener
  public void event(Scalar time, String channel, ByteBuffer byteBuffer) {
    if (channel.equals(GokartLcmChannel.POSE_LIDAR)) {
      GokartPoseEvent gokartPoseInterface = new GokartPoseEvent(byteBuffer);
      Tensor pose = gokartPoseInterface.getPose();
      if (!last.equals(pose)) {
        tableBuilder.appendRow( //
            time.map(Magnitude.SECOND), //
            GokartPoseHelper.toUnitless(pose), //
            gokartPoseInterface.getQuality());
        last = pose;
      }
    }
  }

  @Override // from OfflineTableSupplier
  public Tensor getTable() {
    return tableBuilder.toTable();
  }

  /** @param lcmfile
   * @param dest
   * @throws IOException */
  public static void process(File lcmfile, File dest) throws IOException {
    TimePoseQualityTable timePoseQualityTable = new TimePoseQualityTable();
    OfflineLogPlayer.process(lcmfile, timePoseQualityTable);
    dest.mkdir();
    String name = lcmfile.getName();
    Export.of( //
        new File(dest, name.substring(0, name.length() - 4) + ".csv"), //
        timePoseQualityTable.getTable().map(CsvFormat.strict()));
  }

  public static void main(String[] args) throws IOException {
    File folder = new File("/media/datahaki/media/ethz/gokart/topic/racing3az");
    for (File file : folder.listFiles()) {
      System.out.println(file);
      process(file, UserHome.file("Projects/ephemeral/src/main/resources/dubilab/app/filter/3az"));
    }
    // File file = new File("/media/datahaki/media/ethz/gokart/topic/pedestrian/20180503T160522_1/log.lcm");
    // process(file, UserHome.file("Projects/ephemeral/src/main/resources/dubilab/app/filter/slow"));
  }
}
