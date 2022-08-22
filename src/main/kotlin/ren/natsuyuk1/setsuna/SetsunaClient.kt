package ren.natsuyuk1.setsuna

import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.coroutines.CoroutineName
import ren.natsuyuk1.setsuna.consts.defaultClient
import kotlin.coroutines.CoroutineContext

/**
 * A [SetsunaClient] instance
 *
 * Used for dispatch Twitter API
 *
 * All apis are available in [ren.natsuyuk1.setsuna.api]
 *
 * @param client The [HttpClient] used for request
 * @param coroutineContext [CoroutineContext]
 * @param bearerToken Represents Twitter OAuth 2.0 Bearer Token
 */
class SetsunaClient(
    val client: HttpClient = defaultClient,
    private val coroutineContext: CoroutineContext = CoroutineName("setsuna-client"),
    val bearerToken: String,
) {
    internal fun HttpRequestBuilder.appendAuth() = bearerAuth(bearerToken)
}
