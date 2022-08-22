package ren.natsuyuk1.setsuna.response

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

@Serializable
data class TwitterAPIError(
    val errors: List<JsonObject>,
    val title: String? = null,
    val detail: String? = null,
    val type: String? = null
)
