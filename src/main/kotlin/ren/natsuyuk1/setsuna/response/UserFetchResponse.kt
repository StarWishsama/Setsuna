package ren.natsuyuk1.setsuna.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ren.natsuyuk1.setsuna.objects.TwitterExpansions
import ren.natsuyuk1.setsuna.objects.user.TwitterUser

@Serializable
data class UserFetchResponse(
    @SerialName("data")
    val user: TwitterUser? = null,
    override val errors: List<TwitterAPIError>? = null,
    override val includes: TwitterExpansions? = null,
): TwitterCommonResponse()

@Serializable
data class UsersFetchResponse(
    @SerialName("data")
    val user: List<TwitterUser>? = null,
    override val errors: List<TwitterAPIError>? = null,
    override val includes: TwitterExpansions? = null,
): TwitterCommonResponse()