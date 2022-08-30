package ren.natsuyuk1.setsuna.response

import kotlinx.serialization.Serializable
import ren.natsuyuk1.setsuna.objects.TwitterExpansions

@Serializable
abstract class TwitterCommonResponse {
    abstract val errors: List<TwitterAPIError>?
    abstract val includes: TwitterExpansions?
}