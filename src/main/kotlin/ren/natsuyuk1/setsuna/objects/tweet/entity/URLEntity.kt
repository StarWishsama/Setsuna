package ren.natsuyuk1.setsuna.objects.tweet.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class URLEntity(
    val start: Int,
    val end: Int,
    val url: String,
    @SerialName("expanded_url")
    val expandedURL: String,
    @SerialName("display_url")
    val displayURL: String,
    val status: String? = null,
    val title: String? = null,
    val description: String? = null,
    @SerialName("unwound_url")
    val unwoundURL: String? = null,
    @SerialName("media_key")
    val mediaKey: String? = null,
)