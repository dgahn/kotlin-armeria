package me.dgahn.account.v1;

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
    value = "by gRPC proto compiler (version 1.34.0)",
    comments = "Source: me/dgahn/account/v1/AccountRouteV1.proto")
public final class AccountRouterGrpc {

  private AccountRouterGrpc() {}

  public static final String SERVICE_NAME = "me.dgahn.account.v1.AccountRouter";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<me.dgahn.account.v1.SignUpRequestV1,
      me.dgahn.account.v1.SignUpResponseV1> getSignUpV1Method;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "signUpV1",
      requestType = me.dgahn.account.v1.SignUpRequestV1.class,
      responseType = me.dgahn.account.v1.SignUpResponseV1.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<me.dgahn.account.v1.SignUpRequestV1,
      me.dgahn.account.v1.SignUpResponseV1> getSignUpV1Method() {
    io.grpc.MethodDescriptor<me.dgahn.account.v1.SignUpRequestV1, me.dgahn.account.v1.SignUpResponseV1> getSignUpV1Method;
    if ((getSignUpV1Method = AccountRouterGrpc.getSignUpV1Method) == null) {
      synchronized (AccountRouterGrpc.class) {
        if ((getSignUpV1Method = AccountRouterGrpc.getSignUpV1Method) == null) {
          AccountRouterGrpc.getSignUpV1Method = getSignUpV1Method =
              io.grpc.MethodDescriptor.<me.dgahn.account.v1.SignUpRequestV1, me.dgahn.account.v1.SignUpResponseV1>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "signUpV1"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  me.dgahn.account.v1.SignUpRequestV1.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  me.dgahn.account.v1.SignUpResponseV1.getDefaultInstance()))
              .setSchemaDescriptor(new AccountRouterMethodDescriptorSupplier("signUpV1"))
              .build();
        }
      }
    }
    return getSignUpV1Method;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AccountRouterStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AccountRouterStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AccountRouterStub>() {
        @java.lang.Override
        public AccountRouterStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AccountRouterStub(channel, callOptions);
        }
      };
    return AccountRouterStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AccountRouterBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AccountRouterBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AccountRouterBlockingStub>() {
        @java.lang.Override
        public AccountRouterBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AccountRouterBlockingStub(channel, callOptions);
        }
      };
    return AccountRouterBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AccountRouterFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AccountRouterFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AccountRouterFutureStub>() {
        @java.lang.Override
        public AccountRouterFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AccountRouterFutureStub(channel, callOptions);
        }
      };
    return AccountRouterFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class AccountRouterImplBase implements io.grpc.BindableService {

    /**
     */
    public void signUpV1(me.dgahn.account.v1.SignUpRequestV1 request,
        io.grpc.stub.StreamObserver<me.dgahn.account.v1.SignUpResponseV1> responseObserver) {
      asyncUnimplementedUnaryCall(getSignUpV1Method(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSignUpV1Method(),
            asyncUnaryCall(
              new MethodHandlers<
                me.dgahn.account.v1.SignUpRequestV1,
                me.dgahn.account.v1.SignUpResponseV1>(
                  this, METHODID_SIGN_UP_V1)))
          .build();
    }
  }

  /**
   */
  public static final class AccountRouterStub extends io.grpc.stub.AbstractAsyncStub<AccountRouterStub> {
    private AccountRouterStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccountRouterStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AccountRouterStub(channel, callOptions);
    }

    /**
     */
    public void signUpV1(me.dgahn.account.v1.SignUpRequestV1 request,
        io.grpc.stub.StreamObserver<me.dgahn.account.v1.SignUpResponseV1> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSignUpV1Method(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class AccountRouterBlockingStub extends io.grpc.stub.AbstractBlockingStub<AccountRouterBlockingStub> {
    private AccountRouterBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccountRouterBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AccountRouterBlockingStub(channel, callOptions);
    }

    /**
     */
    public me.dgahn.account.v1.SignUpResponseV1 signUpV1(me.dgahn.account.v1.SignUpRequestV1 request) {
      return blockingUnaryCall(
          getChannel(), getSignUpV1Method(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AccountRouterFutureStub extends io.grpc.stub.AbstractFutureStub<AccountRouterFutureStub> {
    private AccountRouterFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccountRouterFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AccountRouterFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<me.dgahn.account.v1.SignUpResponseV1> signUpV1(
        me.dgahn.account.v1.SignUpRequestV1 request) {
      return futureUnaryCall(
          getChannel().newCall(getSignUpV1Method(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SIGN_UP_V1 = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AccountRouterImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AccountRouterImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SIGN_UP_V1:
          serviceImpl.signUpV1((me.dgahn.account.v1.SignUpRequestV1) request,
              (io.grpc.stub.StreamObserver<me.dgahn.account.v1.SignUpResponseV1>) responseObserver);
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

  private static abstract class AccountRouterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AccountRouterBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return me.dgahn.account.v1.AccountRouteV1.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AccountRouter");
    }
  }

  private static final class AccountRouterFileDescriptorSupplier
      extends AccountRouterBaseDescriptorSupplier {
    AccountRouterFileDescriptorSupplier() {}
  }

  private static final class AccountRouterMethodDescriptorSupplier
      extends AccountRouterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AccountRouterMethodDescriptorSupplier(String methodName) {
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
      synchronized (AccountRouterGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AccountRouterFileDescriptorSupplier())
              .addMethod(getSignUpV1Method())
              .build();
        }
      }
    }
    return result;
  }
}
