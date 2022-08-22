package ren.natsuyuk1.setsuna.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ren.natsuyuk1.setsuna.objects.user.TwitterUser

@Serializable
data class UserFetchResponse(
    @SerialName("data")
    val user: TwitterUser? = null
): TwitterCommonResponse()