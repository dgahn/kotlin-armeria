package me.dgahn.account

import me.dgahn.account.v1.AccountRole
import me.dgahn.account.v1.GetAccountAllResponseV1
import me.dgahn.account.v1.SignUpRequestV1
import me.dgahn.account.v1.SignUpResponseV1

fun SignUpRequestV1.toEntity() = Account(
    id = id,
    password = password,
    name = name
)

fun Account.toProto(): SignUpResponseV1 = SignUpResponseV1.newBuilder()
    .setId(id)
    .build()

fun List<Account>.toProto(): GetAccountAllResponseV1 = GetAccountAllResponseV1.newBuilder()
    .addAllAccounts(
        this.map {
            me.dgahn.account.v1.Account.newBuilder()
                .setId(it.id)
                .setName(it.name)
                .setRole(AccountRole.forNumber(it.id.split("_").last().toInt() % 2))
                .build()
        }
    )
    .build()