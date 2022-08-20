package ren.natsuyuk1.setsuna

import io.ktor.client.HttpClient
import kotlinx.coroutines.CoroutineName
import ren.natsuyuk1.setsuna.consts.defaultClient
import kotlin.coroutines.CoroutineContext

/**
 * A [SetsunaClient] instance
 *
 * Used for dispatch Twitter API
 *
 * @param client The [HttpClient] used for request
 * @param coroutineContext [CoroutineContext]
 * @param bearerToken Represents Twitter OAuth 2.0 Bearer Token
 */
class SetsunaClient(
    val client: HttpClient = defaultClient,
    val coroutineContext: CoroutineContext = CoroutineName("setsuna-client"),
    val bearerToken: String
)
