package me.dgahn.account.v1

import io.grpc.CallOptions
import io.grpc.CallOptions.DEFAULT
import io.grpc.Channel
import io.grpc.Metadata
import io.grpc.MethodDescriptor
import io.grpc.ServerServiceDefinition
import io.grpc.ServerServiceDefinition.builder
import io.grpc.ServiceDescriptor
import io.grpc.Status.UNIMPLEMENTED
import io.grpc.StatusException
import io.grpc.kotlin.AbstractCoroutineServerImpl
import io.grpc.kotlin.AbstractCoroutineStub
import io.grpc.kotlin.ClientCalls.unaryRpc
import io.grpc.kotlin.ServerCalls.unaryServerMethodDefinition
import io.grpc.kotlin.StubFor
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic
import me.dgahn.account.v1.AccountRouterGrpc.getServiceDescriptor

/**
 * Holder for Kotlin coroutine-based client and server APIs for me.dgahn.account.v1.AccountRouter.
 */
object AccountRouterGrpcKt {
  @JvmStatic
  val serviceDescriptor: ServiceDescriptor
    get() = AccountRouterGrpc.getServiceDescriptor()

  val signUpV1Method: MethodDescriptor<SignUpRequestV1, SignUpResponseV1>
    @JvmStatic
    get() = AccountRouterGrpc.getSignUpV1Method()

  /**
   * A stub for issuing RPCs to a(n) me.dgahn.account.v1.AccountRouter service as suspending
   * coroutines.
   */
  @StubFor(AccountRouterGrpc::class)
  class AccountRouterCoroutineStub @JvmOverloads constructor(
    channel: Channel,
    callOptions: CallOptions = DEFAULT
  ) : AbstractCoroutineStub<AccountRouterCoroutineStub>(channel, callOptions) {
    override fun build(channel: Channel, callOptions: CallOptions): AccountRouterCoroutineStub =
        AccountRouterCoroutineStub(channel, callOptions)

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][io.grpc.Status].  If the RPC completes with another status, a
     * corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @return The single response from the server.
     */
    suspend fun signUpV1(request: SignUpRequestV1): SignUpResponseV1 = unaryRpc(
      channel,
      AccountRouterGrpc.getSignUpV1Method(),
      request,
      callOptions,
      Metadata()
    )}

  /**
   * Skeletal implementation of the me.dgahn.account.v1.AccountRouter service based on Kotlin
   * coroutines.
   */
  abstract class AccountRouterCoroutineImplBase(
    coroutineContext: CoroutineContext = EmptyCoroutineContext
  ) : AbstractCoroutineServerImpl(coroutineContext) {
    /**
     * Returns the response to an RPC for me.dgahn.account.v1.AccountRouter.signUpV1.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [io.grpc.Status].  If this method fails with a [java.util.concurrent.CancellationException],
     * the RPC will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    open suspend fun signUpV1(request: SignUpRequestV1): SignUpResponseV1 = throw
        StatusException(UNIMPLEMENTED.withDescription("Method me.dgahn.account.v1.AccountRouter.signUpV1 is unimplemented"))

    final override fun bindService(): ServerServiceDefinition = builder(getServiceDescriptor())
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = AccountRouterGrpc.getSignUpV1Method(),
      implementation = ::signUpV1
    )).build()
  }
}
