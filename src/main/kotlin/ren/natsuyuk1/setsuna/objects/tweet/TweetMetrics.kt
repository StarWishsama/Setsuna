package ren.natsuyuk1.setsuna.objects.tweet

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TweetNonPublicMetrics(
    @SerialName("impression_count")
    val impression: Int,
    @SerialName("url_link_clicks")
    val urlLinkClicks: Int,
    @SerialName("user_profile_clicks")
    val userProfileClicks: Int,
)

@Serializable
data class TweetOrganicMetrics(
    @SerialName("impression_count")
    val impression: Int,
    @SerialName("retweet_count")
    val retweet: Int,
    @SerialName("reply_count")
    val reply: Int,
    @SerialName("like_count")
    val like: Int,
    @SerialName("url_link_clicks")
    val urlLinkClicks: Int,
    @SerialName("user_profile_clicks")
    val userProfileClicks: Int,
)

@Serializable
data class TweetPromotedMetrics(
    @SerialName("impression_count")
    val impression: Int,
    @SerialName("retweet_count")
    val retweet: Int,
    @SerialName("reply_count")
    val reply: Int,
    @SerialName("like_count")
    val like: Int,
    @SerialName("url_link_clicks")
    val urlLinkClicks: Int,
    @SerialName("user_profile_clicks")
    val userProfileClicks: Int,
)

@Serializable
data class TweetPublicMetrics(
    @SerialName("retweet_count")
    val retweet: Int,
    @SerialName("reply_count")
    val reply: Int,
    @SerialName("like_count")
    val like: Int,
    @SerialName("quote_count")
    val quote: Int,
)