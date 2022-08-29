package ren.natsuyuk1.setsuna.objects.tweet.entity

import kotlinx.serialization.Serializable

@Serializable
data class HashTagEntity(
    val start: Int,
    val end: Int,
    val tag: String,
)