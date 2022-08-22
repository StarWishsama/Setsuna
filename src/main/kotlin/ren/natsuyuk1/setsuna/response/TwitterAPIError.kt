package ren.natsuyuk1.setsuna.response

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

@Serializable
data class TwitterAPIError(
    val code: Int? = null,
    val message: String? = null
)
