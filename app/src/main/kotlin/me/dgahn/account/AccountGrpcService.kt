package me.dgahn.account

import com.google.protobuf.Empty
import io.grpc.Status
import io.grpc.StatusException
import kotlinx.coroutines.flow.Flow
import me.dgahn.account.v1.AccountRouterGrpcKt.AccountRouterCoroutineImplBase
import me.dgahn.account.v1.GetAccountAllResponseV1
import me.dgahn.account.v1.GetProfileStreamResponseV1
import me.dgahn.account.v1.SignUpRequestV1
import me.dgahn.account.v1.SignUpResponseV1
import mu.KotlinLogging

private val logger = KotlinLogging.logger { }

class AccountGrpcService : AccountRouterCoroutineImplBase() {

    override suspend fun signUpV1(request: SignUpRequestV1): SignUpResponseV1 = try {
        AccountService.signUp(request.toEntity()).toProto()
    } catch (e: Exception) {
        logger.error { e.stackTraceToString() }
        throw StatusException(Status.UNKNOWN.withDescription(e.stackTraceToString()))
    }

    override fun getProfileStream(request: Empty): Flow<GetProfileStreamResponseV1> = try {
        AccountService.getProfileStream()
    } catch (e: Exception) {
        logger.error { e.stackTraceToString() }
        throw StatusException(Status.UNKNOWN.withDescription(e.stackTraceToString()))
    }

    override suspend fun getAccountAll(request: Empty): GetAccountAllResponseV1 = try {
        AccountService.getAccountAll().toProto()
    } catch (e: Exception) {
        logger.error { e.stackTraceToString() }
        throw StatusException(Status.UNKNOWN.withDescription(e.stackTraceToString()))
    }

}