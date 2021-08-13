package me.dgahn.account

import com.google.protobuf.ByteString
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import me.dgahn.account.v1.GetProfileStreamResponseV1
import java.io.BufferedInputStream
import java.io.File

private const val PIECE_SIZE = 100_000
private const val PIECE_MIN_SIZE = 0
private const val DELAY = 1_000L

object AccountService {
    fun signUp(account: Account) = account

    fun getProfileStream(): Flow<GetProfileStreamResponseV1> {
        val file = File(javaClass.classLoader.getResource("sample.jpg")!!.toURI())
        val fileSize = file.length()
        val fileInputStream = file.inputStream().buffered()
        return flow {
            getProfileStream(fileInputStream, fileSize.toInt())
        }
    }

    private suspend fun FlowCollector<GetProfileStreamResponseV1>.getProfileStream(
        fileInputStream: BufferedInputStream,
        fileSize: Int
    ) {
        var remain = fileSize
        fileInputStream.use {
            while (remain > PIECE_MIN_SIZE) {
                val readLength = if (remain < PIECE_SIZE) remain else PIECE_SIZE
                val readBytes = it.readNBytes(readLength)
                remain -= readLength
                emitProfile(readBytes)
                delay(DELAY)
            }
        }
    }

    private suspend fun FlowCollector<GetProfileStreamResponseV1>.emitProfile(
        readBytes: ByteArray
    ) = emit(
        GetProfileStreamResponseV1.newBuilder()
            .setData(ByteString.copyFrom(readBytes))
            .build()
    )

}