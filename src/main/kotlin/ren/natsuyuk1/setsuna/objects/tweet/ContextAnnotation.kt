package ren.natsuyuk1.setsuna.objects.tweet

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ContextAnnotation(
    @SerialName("domain")
    val domain: DomainContextAnnotation,
    @SerialName("entity")
    val entity: EntityContextAnnotation,
)

@Serializable
data class DomainContextAnnotation(
    val description: String,
    val id: String,
    val name: String,
)

@Serializable
data class EntityContextAnnotation(
    val id: String,
    val name: String
)
