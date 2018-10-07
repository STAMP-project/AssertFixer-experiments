// code by mg
package ch.ethz.idsc.demo.mg.slam;

import java.util.Arrays;

import ch.ethz.idsc.tensor.Tensor;
import ch.ethz.idsc.tensor.Tensors;

/** class to pair go kart frame, world frame and validity field for detected way points */
/** at initialization, no points are detected yet */
public class SlamWaypoints {
  /** go kart frame, ordered by x distance */
  private Tensor gokartWaypoints = Tensors.empty();
  /** same ordered list of points as gokartWaypoints but in world frame */
  private Tensor worldWaypointsOrdered = Tensors.empty();
  /** indicate whether the detected points are counted as valid */
  private boolean[] validities = new boolean[0];

  /** method to set the fields. the validities of all points is set to true
   * 
   * @param gokartWaypoints go kart frame, ordered by x distance
   * @param worldWaypointsOrdered world frame, same ordering as gokartWaypoints */
  public void setGokartWaypoints(Tensor gokartWaypoints, Tensor worldWaypointsOrdered) {
    this.gokartWaypoints = gokartWaypoints;
    this.worldWaypointsOrdered = worldWaypointsOrdered;
    validities = new boolean[gokartWaypoints.length()];
    Arrays.fill(validities, true);
  }

  public void setValidities(boolean[] validities) {
    if (validities.length == gokartWaypoints.length())
      this.validities = validities;
    else
      System.err.println("validities not in sync with gokartWaypoints");
  }

  public boolean[] getValidities() {
    return validities;
  }

  /** @return gokartWaypoints go kart frame */
  public Tensor getGokartWaypoints() {
    return gokartWaypoints;
  }

  /** @return worldWaypoints world frame */
  public Tensor getWorldWaypoints() {
    return worldWaypointsOrdered;
  }

  /** @return validGokartWaypoints go kart frame, only valid way points */
  public Tensor getValidGokartWaypoints() {
    Tensor validGokartWaypoints = Tensors.empty();
    for (int i = 0; i < gokartWaypoints.length(); ++i)
      if (validities[i])
        validGokartWaypoints.append(gokartWaypoints.get(i));
    return validGokartWaypoints;
  }
}
