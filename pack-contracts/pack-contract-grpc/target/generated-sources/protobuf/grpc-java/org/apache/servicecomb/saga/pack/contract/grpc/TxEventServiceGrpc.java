package org.apache.servicecomb.saga.pack.contract.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.11.0)",
    comments = "Source: GrpcTxEvent.proto")
public final class TxEventServiceGrpc {

  private TxEventServiceGrpc() {}

  public static final String SERVICE_NAME = "TxEventService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getOnConnectedMethod()} instead. 
  public static final io.grpc.MethodDescriptor<org.apache.servicecomb.saga.pack.contract.grpc.GrpcServiceConfig,
      org.apache.servicecomb.saga.pack.contract.grpc.GrpcCompensateCommand> METHOD_ON_CONNECTED = getOnConnectedMethodHelper();

  private static volatile io.grpc.MethodDescriptor<org.apache.servicecomb.saga.pack.contract.grpc.GrpcServiceConfig,
      org.apache.servicecomb.saga.pack.contract.grpc.GrpcCompensateCommand> getOnConnectedMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<org.apache.servicecomb.saga.pack.contract.grpc.GrpcServiceConfig,
      org.apache.servicecomb.saga.pack.contract.grpc.GrpcCompensateCommand> getOnConnectedMethod() {
    return getOnConnectedMethodHelper();
  }

  private static io.grpc.MethodDescriptor<org.apache.servicecomb.saga.pack.contract.grpc.GrpcServiceConfig,
      org.apache.servicecomb.saga.pack.contract.grpc.GrpcCompensateCommand> getOnConnectedMethodHelper() {
    io.grpc.MethodDescriptor<org.apache.servicecomb.saga.pack.contract.grpc.GrpcServiceConfig, org.apache.servicecomb.saga.pack.contract.grpc.GrpcCompensateCommand> getOnConnectedMethod;
    if ((getOnConnectedMethod = TxEventServiceGrpc.getOnConnectedMethod) == null) {
      synchronized (TxEventServiceGrpc.class) {
        if ((getOnConnectedMethod = TxEventServiceGrpc.getOnConnectedMethod) == null) {
          TxEventServiceGrpc.getOnConnectedMethod = getOnConnectedMethod = 
              io.grpc.MethodDescriptor.<org.apache.servicecomb.saga.pack.contract.grpc.GrpcServiceConfig, org.apache.servicecomb.saga.pack.contract.grpc.GrpcCompensateCommand>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "TxEventService", "OnConnected"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.apache.servicecomb.saga.pack.contract.grpc.GrpcServiceConfig.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.apache.servicecomb.saga.pack.contract.grpc.GrpcCompensateCommand.getDefaultInstance()))
                  .setSchemaDescriptor(new TxEventServiceMethodDescriptorSupplier("OnConnected"))
                  .build();
          }
        }
     }
     return getOnConnectedMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getOnTxEventMethod()} instead. 
  public static final io.grpc.MethodDescriptor<org.apache.servicecomb.saga.pack.contract.grpc.GrpcTxEvent,
      org.apache.servicecomb.saga.pack.contract.grpc.GrpcAck> METHOD_ON_TX_EVENT = getOnTxEventMethodHelper();

  private static volatile io.grpc.MethodDescriptor<org.apache.servicecomb.saga.pack.contract.grpc.GrpcTxEvent,
      org.apache.servicecomb.saga.pack.contract.grpc.GrpcAck> getOnTxEventMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<org.apache.servicecomb.saga.pack.contract.grpc.GrpcTxEvent,
      org.apache.servicecomb.saga.pack.contract.grpc.GrpcAck> getOnTxEventMethod() {
    return getOnTxEventMethodHelper();
  }

  private static io.grpc.MethodDescriptor<org.apache.servicecomb.saga.pack.contract.grpc.GrpcTxEvent,
      org.apache.servicecomb.saga.pack.contract.grpc.GrpcAck> getOnTxEventMethodHelper() {
    io.grpc.MethodDescriptor<org.apache.servicecomb.saga.pack.contract.grpc.GrpcTxEvent, org.apache.servicecomb.saga.pack.contract.grpc.GrpcAck> getOnTxEventMethod;
    if ((getOnTxEventMethod = TxEventServiceGrpc.getOnTxEventMethod) == null) {
      synchronized (TxEventServiceGrpc.class) {
        if ((getOnTxEventMethod = TxEventServiceGrpc.getOnTxEventMethod) == null) {
          TxEventServiceGrpc.getOnTxEventMethod = getOnTxEventMethod = 
              io.grpc.MethodDescriptor.<org.apache.servicecomb.saga.pack.contract.grpc.GrpcTxEvent, org.apache.servicecomb.saga.pack.contract.grpc.GrpcAck>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "TxEventService", "OnTxEvent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.apache.servicecomb.saga.pack.contract.grpc.GrpcTxEvent.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.apache.servicecomb.saga.pack.contract.grpc.GrpcAck.getDefaultInstance()))
                  .setSchemaDescriptor(new TxEventServiceMethodDescriptorSupplier("OnTxEvent"))
                  .build();
          }
        }
     }
     return getOnTxEventMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getOnDisconnectedMethod()} instead. 
  public static final io.grpc.MethodDescriptor<org.apache.servicecomb.saga.pack.contract.grpc.GrpcServiceConfig,
      org.apache.servicecomb.saga.pack.contract.grpc.GrpcAck> METHOD_ON_DISCONNECTED = getOnDisconnectedMethodHelper();

  private static volatile io.grpc.MethodDescriptor<org.apache.servicecomb.saga.pack.contract.grpc.GrpcServiceConfig,
      org.apache.servicecomb.saga.pack.contract.grpc.GrpcAck> getOnDisconnectedMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<org.apache.servicecomb.saga.pack.contract.grpc.GrpcServiceConfig,
      org.apache.servicecomb.saga.pack.contract.grpc.GrpcAck> getOnDisconnectedMethod() {
    return getOnDisconnectedMethodHelper();
  }

  private static io.grpc.MethodDescriptor<org.apache.servicecomb.saga.pack.contract.grpc.GrpcServiceConfig,
      org.apache.servicecomb.saga.pack.contract.grpc.GrpcAck> getOnDisconnectedMethodHelper() {
    io.grpc.MethodDescriptor<org.apache.servicecomb.saga.pack.contract.grpc.GrpcServiceConfig, org.apache.servicecomb.saga.pack.contract.grpc.GrpcAck> getOnDisconnectedMethod;
    if ((getOnDisconnectedMethod = TxEventServiceGrpc.getOnDisconnectedMethod) == null) {
      synchronized (TxEventServiceGrpc.class) {
        if ((getOnDisconnectedMethod = TxEventServiceGrpc.getOnDisconnectedMethod) == null) {
          TxEventServiceGrpc.getOnDisconnectedMethod = getOnDisconnectedMethod = 
              io.grpc.MethodDescriptor.<org.apache.servicecomb.saga.pack.contract.grpc.GrpcServiceConfig, org.apache.servicecomb.saga.pack.contract.grpc.GrpcAck>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "TxEventService", "OnDisconnected"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.apache.servicecomb.saga.pack.contract.grpc.GrpcServiceConfig.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.apache.servicecomb.saga.pack.contract.grpc.GrpcAck.getDefaultInstance()))
                  .setSchemaDescriptor(new TxEventServiceMethodDescriptorSupplier("OnDisconnected"))
                  .build();
          }
        }
     }
     return getOnDisconnectedMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TxEventServiceStub newStub(io.grpc.Channel channel) {
    return new TxEventServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TxEventServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TxEventServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TxEventServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TxEventServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class TxEventServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void onConnected(org.apache.servicecomb.saga.pack.contract.grpc.GrpcServiceConfig request,
        io.grpc.stub.StreamObserver<org.apache.servicecomb.saga.pack.contract.grpc.GrpcCompensateCommand> responseObserver) {
      asyncUnimplementedUnaryCall(getOnConnectedMethodHelper(), responseObserver);
    }

    /**
     */
    public void onTxEvent(org.apache.servicecomb.saga.pack.contract.grpc.GrpcTxEvent request,
        io.grpc.stub.StreamObserver<org.apache.servicecomb.saga.pack.contract.grpc.GrpcAck> responseObserver) {
      asyncUnimplementedUnaryCall(getOnTxEventMethodHelper(), responseObserver);
    }

    /**
     */
    public void onDisconnected(org.apache.servicecomb.saga.pack.contract.grpc.GrpcServiceConfig request,
        io.grpc.stub.StreamObserver<org.apache.servicecomb.saga.pack.contract.grpc.GrpcAck> responseObserver) {
      asyncUnimplementedUnaryCall(getOnDisconnectedMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getOnConnectedMethodHelper(),
            asyncServerStreamingCall(
              new MethodHandlers<
                org.apache.servicecomb.saga.pack.contract.grpc.GrpcServiceConfig,
                org.apache.servicecomb.saga.pack.contract.grpc.GrpcCompensateCommand>(
                  this, METHODID_ON_CONNECTED)))
          .addMethod(
            getOnTxEventMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                org.apache.servicecomb.saga.pack.contract.grpc.GrpcTxEvent,
                org.apache.servicecomb.saga.pack.contract.grpc.GrpcAck>(
                  this, METHODID_ON_TX_EVENT)))
          .addMethod(
            getOnDisconnectedMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                org.apache.servicecomb.saga.pack.contract.grpc.GrpcServiceConfig,
                org.apache.servicecomb.saga.pack.contract.grpc.GrpcAck>(
                  this, METHODID_ON_DISCONNECTED)))
          .build();
    }
  }

  /**
   */
  public static final class TxEventServiceStub extends io.grpc.stub.AbstractStub<TxEventServiceStub> {
    private TxEventServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TxEventServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TxEventServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TxEventServiceStub(channel, callOptions);
    }

    /**
     */
    public void onConnected(org.apache.servicecomb.saga.pack.contract.grpc.GrpcServiceConfig request,
        io.grpc.stub.StreamObserver<org.apache.servicecomb.saga.pack.contract.grpc.GrpcCompensateCommand> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getOnConnectedMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onTxEvent(org.apache.servicecomb.saga.pack.contract.grpc.GrpcTxEvent request,
        io.grpc.stub.StreamObserver<org.apache.servicecomb.saga.pack.contract.grpc.GrpcAck> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getOnTxEventMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onDisconnected(org.apache.servicecomb.saga.pack.contract.grpc.GrpcServiceConfig request,
        io.grpc.stub.StreamObserver<org.apache.servicecomb.saga.pack.contract.grpc.GrpcAck> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getOnDisconnectedMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class TxEventServiceBlockingStub extends io.grpc.stub.AbstractStub<TxEventServiceBlockingStub> {
    private TxEventServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TxEventServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TxEventServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TxEventServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<org.apache.servicecomb.saga.pack.contract.grpc.GrpcCompensateCommand> onConnected(
        org.apache.servicecomb.saga.pack.contract.grpc.GrpcServiceConfig request) {
      return blockingServerStreamingCall(
          getChannel(), getOnConnectedMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public org.apache.servicecomb.saga.pack.contract.grpc.GrpcAck onTxEvent(org.apache.servicecomb.saga.pack.contract.grpc.GrpcTxEvent request) {
      return blockingUnaryCall(
          getChannel(), getOnTxEventMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public org.apache.servicecomb.saga.pack.contract.grpc.GrpcAck onDisconnected(org.apache.servicecomb.saga.pack.contract.grpc.GrpcServiceConfig request) {
      return blockingUnaryCall(
          getChannel(), getOnDisconnectedMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TxEventServiceFutureStub extends io.grpc.stub.AbstractStub<TxEventServiceFutureStub> {
    private TxEventServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TxEventServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TxEventServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TxEventServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.apache.servicecomb.saga.pack.contract.grpc.GrpcAck> onTxEvent(
        org.apache.servicecomb.saga.pack.contract.grpc.GrpcTxEvent request) {
      return futureUnaryCall(
          getChannel().newCall(getOnTxEventMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.apache.servicecomb.saga.pack.contract.grpc.GrpcAck> onDisconnected(
        org.apache.servicecomb.saga.pack.contract.grpc.GrpcServiceConfig request) {
      return futureUnaryCall(
          getChannel().newCall(getOnDisconnectedMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ON_CONNECTED = 0;
  private static final int METHODID_ON_TX_EVENT = 1;
  private static final int METHODID_ON_DISCONNECTED = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TxEventServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TxEventServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ON_CONNECTED:
          serviceImpl.onConnected((org.apache.servicecomb.saga.pack.contract.grpc.GrpcServiceConfig) request,
              (io.grpc.stub.StreamObserver<org.apache.servicecomb.saga.pack.contract.grpc.GrpcCompensateCommand>) responseObserver);
          break;
        case METHODID_ON_TX_EVENT:
          serviceImpl.onTxEvent((org.apache.servicecomb.saga.pack.contract.grpc.GrpcTxEvent) request,
              (io.grpc.stub.StreamObserver<org.apache.servicecomb.saga.pack.contract.grpc.GrpcAck>) responseObserver);
          break;
        case METHODID_ON_DISCONNECTED:
          serviceImpl.onDisconnected((org.apache.servicecomb.saga.pack.contract.grpc.GrpcServiceConfig) request,
              (io.grpc.stub.StreamObserver<org.apache.servicecomb.saga.pack.contract.grpc.GrpcAck>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class TxEventServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TxEventServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.apache.servicecomb.saga.pack.contract.grpc.TxEventProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TxEventService");
    }
  }

  private static final class TxEventServiceFileDescriptorSupplier
      extends TxEventServiceBaseDescriptorSupplier {
    TxEventServiceFileDescriptorSupplier() {}
  }

  private static final class TxEventServiceMethodDescriptorSupplier
      extends TxEventServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TxEventServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (TxEventServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TxEventServiceFileDescriptorSupplier())
              .addMethod(getOnConnectedMethodHelper())
              .addMethod(getOnTxEventMethodHelper())
              .addMethod(getOnDisconnectedMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
