package ren.natsuyuk1.setsuna.response

import kotlinx.serialization.Serializable
import ren.natsuyuk1.setsuna.objects.TwitterExpansions

@Serializable
open class TwitterCommonResponse(
    val errors: List<TwitterAPIError>? = null,
    val includes: List<TwitterExpansions>? = null,
)