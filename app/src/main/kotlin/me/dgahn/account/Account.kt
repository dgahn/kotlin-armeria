package me.dgahn.account

import me.dgahn.account.v1.AccountRole

data class Account(
    val id: String,
    val password: String,
    val name: String,
    val role: AccountRole = AccountRole.ADMIN
) {
    fun toJson() = buildString {
        append("{")
        append("\t\"id\": \"${id}\", \n")
        append("\t\"name\": \"${name}\", \n")
        append("\t\"role\": \"${role}\" \n")
        append("}")
    }
}

fun List<Account>.toJson(): String = this.joinToString(prefix = "{\n \"accounts\" : [", postfix = "] \n}", separator = ",\n") {
    it.toJson()
}
