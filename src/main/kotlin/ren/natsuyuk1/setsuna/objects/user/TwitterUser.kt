package ren.natsuyuk1.setsuna.objects.user

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject
import ren.natsuyuk1.setsuna.objects.tweet.TweetNonPublicMetrics
import ren.natsuyuk1.setsuna.objects.tweet.TweetWithHeldInfo
import ren.natsuyuk1.setsuna.serializer.ISODateSerializer

/**
 * Represent a [TwitterUser] entity.
 */
@Serializable
data class TwitterUser(
    /**
     * The unique identifier of this user.
     */
    @SerialName("id")
    val id: String,

    /**
     *The name of the user, as they’ve defined it on their profile.
     * Not necessarily a person’s name.
     * Typically capped at 50 characters, but subject to change.
     */
    @SerialName("name")
    val name: String,

    /**
     * The Twitter screen name, handle, or alias that this user identifies themselves with.
     * Usernames are unique but subject to change.
     * Typically a maximum of 15 characters long, but some historical accounts may exist with longer names.
     */
    @SerialName("username")
    val username: String,

    /**
     * Creation time of the Tweet.
     */
    @SerialName("created_at")
    @Serializable(ISODateSerializer::class)
    val createdTime: Instant? = null,

    /**
     * The text of this user's profile description (also known as bio), if the user provided one.
     */
    @SerialName("description")
    val bio: String? = null,

    /**
     * Contains details about text that has a special meaning in the user's description.
     */
    @SerialName("entities")
    val entities: JsonObject? = null,

    /**
     * The location specified in the user's profile, if the user provided one.
     * As this is a freeform value, it may not indicate a valid location,
     * but it may be fuzzily evaluated when performing searches with location queries.
     */
    @SerialName("location")
    val location: String? = null,

    /**
     * Unique identifier of this user's pinned Tweet.
     */
    @SerialName("pinned_tweet_id")
    val pinnedTweetID: String? = null,

    /**
     * The URL to the profile image for this user, as shown on the user's profile.
     */
    @SerialName("profile_image_url")
    val profileImageURL: String? = null,

    /**
     * Indicates if this user has chosen to protect their Tweets (in other words, if this user's Tweets are private).
     */
    @SerialName("protected")
    val protected: Boolean? = null,

    /**
     * Contains details about activity for this user.
     */
    @SerialName("public_metrics")
    val publicMetrics: UserPublicMetrics? = null,

    /**
     * The URL specified in the user's profile, if present.
     */
    val url: String? = null,

    /**
     * Indicates if this user is a verified Twitter User.
     */
    val verified: Boolean? = null,

    /**
     * Contains withholding details for withheld content, if applicable
     *
     * @see https://help.twitter.com/en/rules-and-policies/tweet-withheld-by-country
     */
    @SerialName("withheld")
    val withHeldInfo: TweetWithHeldInfo? = null,
)
