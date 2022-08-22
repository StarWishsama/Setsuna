package ren.natsuyuk1.setsuna.objects.tweet

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TweetWithHeldInfo(
    val copyright: Boolean,
    @SerialName("country_codes")
    val countryCodes: List<String>
)
