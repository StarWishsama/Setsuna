package ren.natsuyuk1.setsuna.objects.tweet

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject
import ren.natsuyuk1.setsuna.response.TwitterCommonResponse
import ren.natsuyuk1.setsuna.serializer.ISODateSerializer

/**
 * A Basic [Tweet] object.
 */
@Serializable
data class Tweet(
    /**
     * Unique identifier of this Tweet.
     */
    val id: String,
    /**
     * The plain content of the Tweet.
     *
     * You can use [String.removeShortLink()] remove short url like `t.co`
     */
    val text: String,

    /**
     * Specifies the type of attachments (if any) present in this Tweet.
     */
    val attachments: TweetAttachments? = null,

    /**
     * The unique identifier of the User who posted this Tweet.
     */
    val authorID: String? = null,

    /**
     * Contains context annotations for the Tweet.
     */
    val contextAnnotations: List<ContextAnnotation>? = null,

    /**
     * The Tweet ID of the original Tweet of the conversation (which includes direct replies, replies of replies).
     */
    @SerialName("conversation_id")
    val conversationID: Long? = null,

    /**
     * Creation time of the Tweet.
     */
    @SerialName("created_at")
    @Serializable(ISODateSerializer::class)
    val createdTime: Instant? = null,

    /**
     * Entities which have been parsed out of the text of the Tweet. Additionally see entities in Twitter Objects.
     */
    val entities: JsonObject? = null,

    /**
     * Contains details about the location tagged by the user in this Tweet, if they specified one.
     */
    @SerialName("geo")
    val geoInfo: TweetGeoInfo? = null,

    /**
     * If the represented Tweet is a reply, this field will contain the original Tweet’s author ID.
     * This will not necessarily always be the user directly mentioned in the Tweet.
     */
    @SerialName("in_reply_to_user_id")
    val replyUserID: String? = null,

    /**
     * Language of the Tweet, if detected by Twitter.
     *
     * Returned as a BCP47 language tag.
     */
    val lang: String? = null,

    /**
     * Non-public engagement metrics for the Tweet at the time of the request.
     *
     * Requires user context authentication.
     */
    @SerialName("non_public_metrics")
    val nonPublicMetrics: TweetNonPublicMetrics? = null,

    /**
     * Engagement metrics, tracked in an organic context, for the Tweet at the time of the request.
     *
     * Requires user context authentication.
     */
    @SerialName("organic_metrics")
    val organicMetrics: TweetOrganicMetrics? = null,

    /**
     * This field only surfaces when a Tweet contains a link.
     * The meaning of the field doesn’t pertain to the Tweet content itself,
     * but instead it is an indicator that the URL contained in the Tweet may contain content or media identified as sensitive content.
     */
    @SerialName("possibly_sensitive")
    val possiblySensitive: Boolean? = null,

    /**
     * Engagement metrics, tracked in a promoted context, for the Tweet at the time of the request.
     *
     * Requires user context authentication.
     */
    @SerialName("promoted_metrics")
    val promotedMetrics: TweetPromotedMetrics? = null,

    /**
     * Public engagement metrics for the Tweet at the time of the request.
     */
    @SerialName("public_metrics")
    val publicMetrics: TweetPublicMetrics? = null,

    /**
     * A list of Tweets this Tweet refers to.
     * For example, if the parent Tweet is a Retweet, a Retweet with comment (also known as Quoted Tweet) or a Reply,
     * it will include the related Tweet referenced to by its parent.
     */
    @SerialName("referenced_tweets")
    val referencedTweets: List<ReferencedTweets>? = null,

    /**
     * Shows you who can reply to a given Tweet.
     * Fields returned as [TweetReplySetting].
     */
    @SerialName("reply_settings")
    val replySetting: TweetReplySetting? = null,

    /**
     * The name of the app the user Tweeted from.
     * e.g. Twitter Web App
     */
    @SerialName("source")
    val source: String? = null,

    val withheld: TweetWithHeldInfo? = null,
): TwitterCommonResponse()
