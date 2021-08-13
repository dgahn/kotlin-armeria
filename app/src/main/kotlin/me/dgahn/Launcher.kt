package me.dgahn

import com.linecorp.armeria.common.grpc.GrpcSerializationFormats
import com.linecorp.armeria.server.Server
import com.linecorp.armeria.server.ServerBuilder
import com.linecorp.armeria.server.docs.DocService
import com.linecorp.armeria.server.grpc.GrpcService
import me.dgahn.account.AccountGrpcService
import me.dgahn.account.AccountHttpService
import mu.KotlinLogging

private val logger = KotlinLogging.logger { }

fun main() {
    newServerAndStart()
}

internal fun newServerAndStart(httpPort: Int = 8080, httpsPort: Int = 8433) = newServer(httpPort, httpsPort)
    .startServer()

private fun Server.startServer() {
    Runtime.getRuntime().addShutdownHook(Thread {
        stop().join()
        logger.info("Server has been stopped.")
    })
    start().join()
    logger.info(
        "Server has been started. Serving DocService at http://127.0.0.1:{}/docs",
        activeLocalPort()
    )
}

private fun newServer(httpPort: Int = 8080, httpsPort: Int = 8433): Server = Server.builder()
    .setHttp(httpPort, httpsPort)
    .setGrpcService()
    .setHttpService()
    .build()

private fun ServerBuilder.setHttp(httpPort: Int, httpsPort: Int) = this.apply {
    http(httpPort)
    https(httpsPort)
    tlsSelfSigned()
}

private fun ServerBuilder.setGrpcService() = this.apply {
    val grpcService = createGrpcService()
    service(grpcService)
    service("/", grpcService)
    serviceUnder("/docs", DocService.builder().build())
}

private fun ServerBuilder.setHttpService() = this.apply {
    annotatedService(AccountHttpService())
}

private fun createGrpcService(): GrpcService = GrpcService.builder()
    .addService(AccountGrpcService())
    .supportedSerializationFormats(GrpcSerializationFormats.values())
    .enableUnframedRequests(true)
    .build()

