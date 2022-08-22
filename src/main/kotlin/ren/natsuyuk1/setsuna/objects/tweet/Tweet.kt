package ren.natsuyuk1.setsuna.objects.tweet

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ren.natsuyuk1.setsuna.objects.TwitterCommonResponse

@Serializable
class Tweet(
    /**
     * Unique identifier of this Tweet.
     */
    val id: String,
    /**
     * The plain content of the Tweet.
     *
     * You can use
     */
    val text: String,
    @SerialName("conversation_id")
    val conversationID: Long? = null,
    @SerialName("public_metrics")
    val publicMetrics: TweetPublicMetrics? = null
): TwitterCommonResponse()
