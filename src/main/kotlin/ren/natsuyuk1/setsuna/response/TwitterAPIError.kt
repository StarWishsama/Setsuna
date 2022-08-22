package ren.natsuyuk1.setsuna.response

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

@Serializable
data class TwitterAPIError(
    /**
     * Twitter API error code
     *
     * @see https://developer.twitter.com/en/support/twitter-api/error-troubleshooting#error-codes
     */
    val code: Int? = null,
    val message: String? = null
)
