package ren.natsuyuk1.setsuna.objects

import kotlinx.serialization.Serializable
import ren.natsuyuk1.setsuna.response.TwitterAPIError

@Serializable
open class TwitterCommonResponse(
    val errors: List<TwitterAPIError>? = null,
)