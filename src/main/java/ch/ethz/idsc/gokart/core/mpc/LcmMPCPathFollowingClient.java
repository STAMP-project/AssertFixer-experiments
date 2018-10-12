// code by mh
package ch.ethz.idsc.gokart.core.mpc;

import java.nio.ByteBuffer;

import ch.ethz.idsc.retina.lcm.BinaryBlobPublisher;
import ch.ethz.idsc.retina.lcm.BinaryBlobs;
import ch.ethz.idsc.retina.lcm.BinaryLcmClient;
import ch.ethz.idsc.retina.lcm.LcmClientInterface;
import idsc.BinaryBlob;

public class LcmMPCPathFollowingClient implements MPCPathFollowingClient, LcmClientInterface {
  MPCNativeSession mpcNativeSession;
  private final BinaryBlobPublisher gokartStatePublisher = new BinaryBlobPublisher("mpc.forces.gs");
  private final BinaryBlobPublisher pathParameterPublisher = new BinaryBlobPublisher("mpc.forces.pp");
  private final BinaryBlobPublisher optimizationParameterPublisher = new BinaryBlobPublisher("mpc.forces.op");
  BinaryLcmClient binaryLcmClient = new BinaryLcmClient() {
    @Override
    protected void messageReceived(ByteBuffer byteBuffer) {
      //get new message
      ControlAndPredictionSteps cns = new ControlAndPredictionSteps(byteBuffer);
    }

    @Override
    protected String channel() {
      return "mpc.forces.cns";
    }
  };

  @Override
  public void start() {
    mpcNativeSession.first();
  }

  @Override
  public void stop() {
    mpcNativeSession.last();
  }

  public void publishGokartState(GokartState gokartState) {
    GokartStateMessage gokartStateMessage = new GokartStateMessage(gokartState, mpcNativeSession);
    BinaryBlob binaryBlob = BinaryBlobs.create(gokartStateMessage.length());
    ByteBuffer byteBuffer = ByteBuffer.wrap(binaryBlob.data);
    gokartStateMessage.insert(byteBuffer);
    gokartStatePublisher.accept(binaryBlob);
  }

  public void publishPathParameter(MPCPathParameter mpcPathParameter) {
    MPCPathParameterMessage mpcPathParameterMessage = new MPCPathParameterMessage(mpcPathParameter, mpcNativeSession);
    BinaryBlob binaryBlob = BinaryBlobs.create(mpcPathParameterMessage.length());
    ByteBuffer byteBuffer = ByteBuffer.wrap(binaryBlob.data);
    mpcPathParameterMessage.insert(byteBuffer);
    pathParameterPublisher.accept(binaryBlob);
  }

  public void publishOptimizationParameter(MPCOptimizationParameter mpcOptimizationParameter) {
    MPCOptimizationParameterMessage mpcOptimizationParameterMessage = new MPCOptimizationParameterMessage(mpcOptimizationParameter, mpcNativeSession);
    BinaryBlob binaryBlob = BinaryBlobs.create(mpcOptimizationParameterMessage.length());
    ByteBuffer byteBuffer = ByteBuffer.wrap(binaryBlob.data);
    mpcOptimizationParameterMessage.insert(byteBuffer);
    optimizationParameterPublisher.accept(binaryBlob);
  }

  @Override
  public void startSubscriptions() {
    // TODO Auto-generated method stub
  }

  @Override
  public void stopSubscriptions() {
    // TODO Auto-generated method stub
  }
}
