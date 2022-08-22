package ren.natsuyuk1.setsuna.objects.tweet

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TweetPublicMetrics(
    @SerialName("retweet_count")
    val retweet: Int,
    @SerialName("reply_count")
    val reply: Int,
    @SerialName("like_count")
    val like: Int,
    @SerialName("quote_count")
    val quote: Int,
)