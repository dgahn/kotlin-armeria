package me.dgahn.account

import com.google.protobuf.Empty
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.flow.collect
import mu.KotlinLogging
import java.io.BufferedOutputStream
import java.io.File
import java.io.FileOutputStream

private val logger = KotlinLogging.logger {  }

class AccountRouteServiceTest : FunSpec({

    val service = AccountRouteService()

    afterEach {
        File("sample.jpg").delete()
    }

    test("프로필을 스트림으로 받을 수 있다") {
        val response = service.getProfileStream(Empty.getDefaultInstance())
        val savedFile = File("sample.jpg")
        val outBuffer = BufferedOutputStream(FileOutputStream(savedFile))
        outBuffer.use { stream ->
            response.collect {
                val data = it.data.toByteArray()
                logger.info { "전송 받은 데이터 크기 : ${data.size}" }
                stream.write(data)
            }
        }

        File(this.javaClass.classLoader.getResource("sample.jpg")!!.toURI()).length() shouldBe savedFile.length()
    }

})