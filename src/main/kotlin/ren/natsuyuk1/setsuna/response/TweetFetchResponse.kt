package ren.natsuyuk1.setsuna.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ren.natsuyuk1.setsuna.objects.TwitterExpansions
import ren.natsuyuk1.setsuna.objects.TwitterMeta
import ren.natsuyuk1.setsuna.objects.tweet.Tweet

@Serializable
data class TweetFetchResponse(
    @SerialName("data")
    val tweet: Tweet? = null,
    override val errors: List<TwitterAPIError>? = null,
    override val includes: TwitterExpansions? = null,
): TwitterCommonResponse()

@Serializable
data class MultipleTweetFetchResponse(
    @SerialName("data")
    val tweets: List<Tweet>? = null,
    override val errors: List<TwitterAPIError>? = null,
    override val includes: TwitterExpansions? = null,
): TwitterCommonResponse()

@Serializable
data class UserTimelineResponse(
    @SerialName("data")
    val tweets: List<Tweet>? = null,
    @SerialName("meta")
    val meta: TwitterMeta? = null,
    override val errors: List<TwitterAPIError>? = null,
    override val includes: TwitterExpansions? = null,
): TwitterCommonResponse()
