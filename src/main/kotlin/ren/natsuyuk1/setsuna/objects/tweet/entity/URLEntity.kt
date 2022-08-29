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
    val status: String,
    val title: String,
    val description: String,
    @SerialName("unwound_url")
    val unwoundURL: String,
)