package ren.natsuyuk1.setsuna.objects.tweet

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class TweetReplySetting {
    @SerialName("everyone")
    EVERYONE,
    @SerialName("mentioned_users")
    MENTIONED_USERS,
    @SerialName("followers")
    FOLLOWERS,
}

@Serializable
enum class ReferencedTweetType {
    @SerialName("retweeted")
    RETWEETED,
    @SerialName("quoted")
    QUOTED,
    @SerialName("replied_to")
    REPLY_TO,
}