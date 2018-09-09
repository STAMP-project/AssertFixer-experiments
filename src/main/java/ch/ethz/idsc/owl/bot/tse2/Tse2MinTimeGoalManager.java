// code by jl, ynager
package ch.ethz.idsc.owl.bot.tse2;

import java.util.Collection;

import ch.ethz.idsc.owl.glc.adapter.AbstractMinTimeGoalManager;
import ch.ethz.idsc.owl.math.flow.Flow;
import ch.ethz.idsc.tensor.Scalar;
import ch.ethz.idsc.tensor.Tensor;
import ch.ethz.idsc.tensor.Tensors;
import ch.ethz.idsc.tensor.red.Max;

/** min time cost function with indecent heuristic
 * 
 * Note: class cannot be derived from Se2MinTimeGoalManager
 * because the se2 flows assume constant speed.
 * For Tse2, the min-time to reach goal formula is more complicated. */
public final class Tse2MinTimeGoalManager extends AbstractMinTimeGoalManager {
  private final Tse2ComboRegion tse2ComboRegion;
  private final Scalar maxSpeed;
  private final Scalar maxTurning;
  @SuppressWarnings("unused")
  private final Tensor minmaxAcc; // TODO YN make use of max accelerations for heuristic

  public Tse2MinTimeGoalManager(Tse2ComboRegion tse2ComboRegion, Collection<Flow> controls, Scalar maxSpeed) {
    super(tse2ComboRegion);
    this.tse2ComboRegion = tse2ComboRegion;
    this.maxSpeed = maxSpeed; // TODO YN max speed for forward and reverse
    this.maxTurning = Tse2Controls.maxTurning(controls);
    this.minmaxAcc = Tensors.of(Tse2Controls.minAcc(controls), Tse2Controls.maxAcc(controls));
  }

  @Override // from HeuristicFunction
  public Scalar minCostToGoal(Tensor tensor) {
    // units: d_xy [m] / maxSpeed [m/s] -> time [s]
    // units: d_an [rad] / maxTurning [rad/s] -> time [s]
    // FIXME YN admissible but inaccurate heuristic -> use accelerations for a better bound
    return Max.of( //
        tse2ComboRegion.d_xy(tensor).divide(maxSpeed), //
        tse2ComboRegion.d_angle(tensor).divide(maxTurning.multiply(maxSpeed)));
  }
}
