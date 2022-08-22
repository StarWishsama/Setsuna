package ren.natsuyuk1.setsuna.objects.tweet

import kotlinx.serialization.Serializable

@Serializable
data class ReferencedTweets(
    val type: String,
    val id: String
)
