package ren.natsuyuk1.setsuna.objects

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TwitterMeta(
    @SerialName("oldest_id")
    val oldestID: String,
    @SerialName("newest_id")
    val newestID: String,
    @SerialName("result_count")
    val resultCount: Int,
    @SerialName("next_token")
    val nextToken: String
)