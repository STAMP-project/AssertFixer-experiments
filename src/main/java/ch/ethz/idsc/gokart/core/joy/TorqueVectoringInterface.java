// code by mh
package ch.ethz.idsc.gokart.core.joy;

import ch.ethz.idsc.tensor.Scalar;
import ch.ethz.idsc.tensor.Tensor;

public interface TorqueVectoringInterface {
  /** @param expectedRotationPerMeterDriven with unit m^-1
   * @param meanTangentSpeed with unit m*s^-1
   * @param angularSlip with unit s^-1
   * @param power unitless in the interval [-1, 1]
   * @param real rotation taken from gyro with unit s^-1
   * @return vector of the form {powerLeft, powerRight} where both
   * powerLeft and powerRight are guaranteed to be in the interval [-1, 1] */
  public Tensor powers( //
      Scalar expectedRotationPerMeterDriven, //
      Scalar meanTangentSpeed, //
      Scalar angularSlip, //
      Scalar power, //
      Scalar realRotation);
}
