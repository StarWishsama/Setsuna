package ren.natsuyuk1.setsuna.objects.tweet.entity

import kotlinx.serialization.Serializable

@Serializable
data class MentionEntity(
    val start: Int,
    val end: Int,
    val username: String,
    val id: String
)