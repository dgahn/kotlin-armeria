package me.dgahn.account

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