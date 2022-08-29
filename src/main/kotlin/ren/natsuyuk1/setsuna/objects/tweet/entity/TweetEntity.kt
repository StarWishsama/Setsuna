package ren.natsuyuk1.setsuna.objects.tweet.entity

import kotlinx.serialization.Serializable

@Serializable
data class TweetEntity(
    val annotations: List<AnnotationEntity>? = null,
    val cashtags: List<CashTagEntity>? = null,
    val hashtags: List<HashTagEntity>? = null,
    val mentions: List<MentionEntity>? = null,
    val urls: List<URLEntity>? = null,
)