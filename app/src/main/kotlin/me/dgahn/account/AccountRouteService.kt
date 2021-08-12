package me.dgahn.account

import io.grpc.Status
import io.grpc.StatusException
import me.dgahn.account.v1.AccountRouterGrpcKt.AccountRouterCoroutineImplBase
import me.dgahn.account.v1.SignUpRequestV1
import me.dgahn.account.v1.SignUpResponseV1
import mu.KotlinLogging

private val logger = KotlinLogging.logger {  }

class AccountRouteService: AccountRouterCoroutineImplBase() {

    override suspend fun signUpV1(request: SignUpRequestV1): SignUpResponseV1 = try {
        AccountService.signUp(request.toEntity()).toProto()
    } catch (e: Exception) {
        logger.error { e.stackTraceToString() }
        throw StatusException(Status.UNKNOWN.withDescription(e.stackTraceToString()))
    }

}