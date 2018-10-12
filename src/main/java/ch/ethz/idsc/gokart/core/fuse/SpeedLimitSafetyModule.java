// code by jph
package ch.ethz.idsc.gokart.core.fuse;

import java.util.Optional;

import ch.ethz.idsc.gokart.core.PutProvider;
import ch.ethz.idsc.owl.math.state.ProviderRank;
import ch.ethz.idsc.retina.dev.rimo.RimoGetEvent;
import ch.ethz.idsc.retina.dev.rimo.RimoGetListener;
import ch.ethz.idsc.retina.dev.rimo.RimoPutEvent;
import ch.ethz.idsc.retina.dev.rimo.RimoSocket;
import ch.ethz.idsc.retina.sys.AbstractModule;
import ch.ethz.idsc.retina.util.data.PenaltyTimeout;
import ch.ethz.idsc.retina.util.math.Magnitude;
import ch.ethz.idsc.tensor.Scalar;
import ch.ethz.idsc.tensor.Scalars;
import ch.ethz.idsc.tensor.red.Max;

/** The module has {@link ProviderRank#SAFETY} to prevent autonomous
 * modules to accelerate if either wheel rate exceeds threshold */
public final class SpeedLimitSafetyModule extends AbstractModule implements RimoGetListener, PutProvider<RimoPutEvent> {
  private final PenaltyTimeout penaltyTimeout = //
      new PenaltyTimeout(Magnitude.SECOND.toDouble(SafetyConfig.GLOBAL.penalty));

  @Override // from AbstractModule
  protected void first() throws Exception {
    RimoSocket.INSTANCE.addGetListener(this);
    RimoSocket.INSTANCE.addPutProvider(this);
  }

  @Override // from AbstractModule
  protected void last() {
    RimoSocket.INSTANCE.removePutProvider(this);
    RimoSocket.INSTANCE.removeGetListener(this);
  }

  @Override // from LinmotGetListener
  public void getEvent(RimoGetEvent rimoGetEvent) {
    Scalar maxSpeed = Max.of( //
        rimoGetEvent.getTireL.getAngularRate_Y().abs(), //
        rimoGetEvent.getTireR.getAngularRate_Y().abs());
    if (Scalars.lessThan(SafetyConfig.GLOBAL.rateLimit, maxSpeed))
      penaltyTimeout.flagPenalty();
  }

  @Override // from PutProvider
  public ProviderRank getProviderRank() {
    return ProviderRank.SAFETY;
  }

  @Override // from PutProvider
  public Optional<RimoPutEvent> putEvent() {
    return penaltyTimeout.isPenalty() //
        ? StaticHelper.OPTIONAL_RIMO_PASSIVE
        : Optional.empty();
  }
}
