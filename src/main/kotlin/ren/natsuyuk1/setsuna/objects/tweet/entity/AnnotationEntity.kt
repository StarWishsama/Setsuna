package ren.natsuyuk1.setsuna.objects.tweet.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AnnotationEntity(
    val start: Int,
    val end: Int,
    @SerialName("normalized_text")
    val normalizedText: String,
    val probability: Double,
    val type: String,
)