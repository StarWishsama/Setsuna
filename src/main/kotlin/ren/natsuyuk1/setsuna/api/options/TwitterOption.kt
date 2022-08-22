package ren.natsuyuk1.setsuna.api.options

import io.ktor.client.request.*
import io.ktor.http.*

/**
 * The [TweetOption] enables you to select which
 * specific [Tweet] fields will deliver in API response.
 */
enum class TweetOption(
    internal val param: String,
    val isLimited: Boolean = false
) {
    /**
     * Specifies the type of attachments (if any) present in this Tweet.
     * (e.g. media)
     */
    ATTACHMENTS("attachments"),

    /**
     * Unique identifier of this user.
     */
    AUTHOR_ID("author_id"),

    /**
     * Contains context annotations for the Tweet.
     */
    CONTEXT_ANNOTATIONS("context_annotations"),
    CONVERSATION_ID("conversation_id"),
    CREATED_DATE("created_at"),

    /**
     * Contains details about text that has a special meaning in a Tweet.
     */
    TWEET_ENTITIES("entities"),

    /**
     * Contains details about the location tagged by the user in this Tweet,
     * if they specified one.
     */
    GEO("geo"),

    /**
     * If this Tweet is a Reply, indicates the user ID of the parent Tweet's author.
     */
    REPLY_USER_ID("in_reply_to_user_id"),

    /**
     * Language of the Tweet, if detected by Twitter.
     * Returned as a BCP47 language tag.
     */
    LANG("lang"),

    /**
     * Non-public engagement metrics for the Tweet at the time of the request.
     * This is a private metric, and requires the use of OAuth 2.0 User Context authentication.
     */
    NON_PUBLIC_METRICS("non_public_metrics", true),

    /**
     * Engagement metrics for the Tweet at the time of the request.
     */
    PUBLIC_METRICS("public_metrics"),

    /**
     * Organic engagement metrics for the Tweet at the time of the request.
     * Requires user context authentication.
     */
    ORGANIC_METRICS("organic_metrics", true),

    /**
     * Engagement metrics for the Tweet at the time of the request in a promoted context.
     * Requires user context authentication.
     */
    PROMOTED_METRICS("promoted_metrics", true),

    /**
     * Indicates if this Tweet contains URLs marked as sensitive,
     * for example content suitable for mature audiences.
     */
    POSSIBLY_SENSITIVE("possibly_sensitive"),

    /**
     * A list of Tweets this Tweet refers to.
     * For example, if the parent Tweet is a Retweet, a Retweet with comment (also known as Quoted Tweet) or a Reply,
     * it will include the related Tweet referenced to by its parent.
     */
    REFERENCED_TWEETS("referenced_tweets"),

    /**
     * Shows who can reply to this Tweet.
     */
    REPLY_SETTINGS("reply_settings"),

    /**
     * The name of the app the user Tweeted from.
     */
    SOURCE("source"),

    /**
     * The content of the Tweet, default enabled.
     */
    TEXT("text"),

    /**
     * Contains withholding details for withheld content.
     *
     * More about withheld, check:
     * https://help.twitter.com/en/rules-and-policies/tweet-withheld-by-country
     */
    WITHHELD("withheld"),
}

internal fun HttpRequestBuilder.appendOption(options: List<TweetOption>) = run {
    if (options.isEmpty()) {
        return@run
    }

    parameter("tweet.fields", buildString {
        options.forEach {
            append("${it.param},")
        }
    }.dropLast(1))
}

val defaultTweetOption: List<TweetOption> by lazy { TweetOption.values().filter { !it.isLimited } }