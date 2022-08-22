package ren.natsuyuk1.setsuna.objects.tweet

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TweetAttachments(
    @SerialName("media_keys")
    val mediaKeys: List<String>? = null,
    @SerialName("poll_ids")
    val pollIDs: List<String>? = null,
)