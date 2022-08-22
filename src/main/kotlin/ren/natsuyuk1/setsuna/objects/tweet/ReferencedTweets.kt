package ren.natsuyuk1.setsuna.objects.tweet

import kotlinx.serialization.Serializable

@Serializable
data class ReferencedTweets(
    val type: ReferencedTweetType,
    val id: String
)
