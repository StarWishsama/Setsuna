package ren.natsuyuk1.setsuna.objects.user

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserPublicMetrics(
    @SerialName("followers_count")
    val followers: Int,
    @SerialName("following_count")
    val following: Int,
    @SerialName("tweet_count")
    val tweet: Int,
    @SerialName("listed_count")
    val list: Int,
)