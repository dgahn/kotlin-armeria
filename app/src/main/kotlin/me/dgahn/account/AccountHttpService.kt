package me.dgahn.account

import com.google.protobuf.Message
import com.google.protobuf.util.JsonFormat
import com.linecorp.armeria.common.*
import com.linecorp.armeria.server.annotation.Get

class AccountHttpService {

    @Get("/accounts")
    fun getAccountAll(): HttpResponse {
        val accounts = AccountService.getAccountAll()
        return HttpResponse.of(MediaType.JSON, accounts.toJson())
    }

    @Get("/v2/accounts")
    fun getAccountAllV2(): HttpResponse {
        val accounts = AccountService.getAccountAll().toProto()
        return HttpResponse.of(ResponseHeaders.of(HttpStatus.OK), HttpData.wrap(accounts.toByteArray()))
    }

}

inline fun <reified T : Message> T.toJson(): String = JsonFormat.printer().print(this)