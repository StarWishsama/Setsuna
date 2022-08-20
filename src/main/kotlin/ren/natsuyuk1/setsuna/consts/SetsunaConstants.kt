package ren.natsuyuk1.setsuna.consts

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.compression.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import ren.natsuyuk1.setsuna.Setsuna
import kotlin.time.Duration.Companion.seconds

internal val defaultJson
    get() = Setsuna.defaultJson.value

internal val defaultClient = HttpClient(CIO) {
    install(UserAgent) {
        agent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.0.0 Safari/537.36"
    }

    install(ContentEncoding) {
        gzip()
        deflate()
        identity()
    }

    install(ContentNegotiation) {
        json(defaultJson)
    }

    install(HttpTimeout) {
        requestTimeoutMillis = 10.seconds.inWholeMilliseconds
    }
}
