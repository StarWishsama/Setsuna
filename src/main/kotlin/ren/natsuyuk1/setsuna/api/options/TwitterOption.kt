package ren.natsuyuk1.setsuna.api.options

import io.ktor.client.request.*
import io.ktor.http.*
import ren.natsuyuk1.setsuna.consts.TWEET_FIELD
import ren.natsuyuk1.setsuna.consts.USER_FIELD

internal fun HttpRequestBuilder.appendOption(options: List<TwitterOption>) = run {
    if (options.isEmpty()) {
        return@run
    }

    parameter(options.first().fieldName, buildString {
        options.forEach {
            append("${it.param},")
        }
    }.dropLast(1))
}

sealed class TwitterOption(internal val fieldName: String, internal val param: String, val isLimited: Boolean = false)

/**
 * The [CustomTwitterOption] is for enable field
 * which setsuna isn't support now.
 *
 * May remove in the future.
 */
class CustomTwitterOption(fieldName: String, value: String): TwitterOption(fieldName, value)

/**
 * The [TweetOption] enables you to select which
 * specific [Tweet] fields will deliver in API response.
 */
sealed class TweetOption(param: String, isLimited: Boolean = false): TwitterOption(TWEET_FIELD, param, isLimited) {
    /**
     * Specifies the type of attachments (if any) present in this Tweet.
     * (e.g. media)
     */
    class Attachments: TweetOption("attachments")

    /**
     * Unique identifier of this user.
     */
    class AuthorID: TweetOption("author_id")

    /**
     * Contains context annotations for the Tweet.
     */
    class ContextAnnotations: TweetOption("context_annotations")

    class ConversationID: TweetOption("conversation_id")

    class CreatedDate: TweetOption("created_at")

    /**
     * Contains details about text that has a special meaning in a Tweet.
     */
    class Entities: TweetOption("entities")

    /**
     * Contains details about the location tagged by the user in this Tweet,
     * if they specified one.
     */
    class Geo: TweetOption("geo")

    /**
     * If this Tweet is a Reply, indicates the user ID of the parent Tweet's author.
     */
    class ReplyUserID: TweetOption("in_reply_to_user_id")

    /**
     * Language of the Tweet, if detected by Twitter.
     * Returned as a BCP47 language tag.
     */
    class Lang: TweetOption("lang")

    /**
     * Non-public engagement metrics for the Tweet at the time of the request.
     * This is a private metric, and requires the use of OAuth 2.0 User Context authentication.
     */
    class NonPublicMetrics: TweetOption("non_public_metrics", true)

    /**
     * Engagement metrics for the Tweet at the time of the request.
     */
    class PublicMetrics: TweetOption("public_metrics")

    /**
     * Organic engagement metrics for the Tweet at the time of the request.
     * Requires user context authentication.
     */
    class OrganicMetrics: TweetOption("organic_metrics", true)

    /**
     * Engagement metrics for the Tweet at the time of the request in a promoted context.
     * Requires user context authentication.
     */
    class PromotedMetrics: TweetOption("promoted_metrics", true)

    /**
     * Indicates if this Tweet contains URLs marked as sensitive,
     * for example content suitable for mature audiences.
     */
    class PossiblySensitive: TweetOption("possibly_sensitive")

    /**
     * A list of Tweets this Tweet refers to.
     * For example, if the parent Tweet is a Retweet, a Retweet with comment (also known as Quoted Tweet) or a Reply,
     * it will include the related Tweet referenced to by its parent.
     */
    class ReferencedTweets: TweetOption("referenced_tweets")

    /**
     * Shows who can reply to this Tweet.
     */
    class ReplySettings: TweetOption("reply_settings")

    /**
     * The name of the app the user Tweeted from.
     */
    class Source: TweetOption("source")

    /**
     * The content of the Tweet, default enabled.
     */
    class Text: TweetOption("text")

    /**
     * Contains withholding details for withheld content.
     *
     * More about withheld, check:
     * https://help.twitter.com/en/rules-and-policies/tweet-withheld-by-country
     */
    class WithHeld: TweetOption("withheld")
}

val defaultTweetOption: List<TweetOption> by lazy {
    listOf(
        TweetOption.Attachments(),
        TweetOption.AuthorID(),
        TweetOption.PossiblySensitive(),
        TweetOption.ReferencedTweets(),
        TweetOption.Text(),
        TweetOption.WithHeld(),
        TweetOption.Source(),
        TweetOption.ReplySettings(),
        TweetOption.Lang(),
        TweetOption.Geo(),
        TweetOption.ReplyUserID(),
        TweetOption.Entities(),
        TweetOption.CreatedDate(),
        TweetOption.ConversationID(),
        TweetOption.ContextAnnotations(),
        TweetOption.PublicMetrics()
    )
}

sealed class UserOption(param: String, isLimited: Boolean = false): TwitterOption(USER_FIELD, param, isLimited) {
    class CreatedDate: UserOption("created_at")
    class Description: UserOption("description")
    class Entities: UserOption("entities")
    class ID: UserOption("id")
    class Location: UserOption("location")
    class Name: UserOption("name")
    class PinnedTweetID: UserOption("pinned_tweet_id")
    class ProfileImageURL: UserOption("profile_image_url")
    class Protected: UserOption("protected")
    class PublicMetrics: UserOption("public_metrics")
    class URL: UserOption("url")
    class Username: UserOption("username")
    class Verified: UserOption("verified")
    class WithHeld: UserOption("withheld")
}

val defaultUserOption: List<UserOption> by lazy {
    listOf(
        UserOption.CreatedDate(),
        UserOption.Description(),
        UserOption.Entities(),
        UserOption.ID(),
        UserOption.Location(),
        UserOption.Name(),
        UserOption.PinnedTweetID(),
        UserOption.ProfileImageURL(),
        UserOption.Protected(),
        UserOption.PublicMetrics(),
        UserOption.URL(),
        UserOption.Username(),
        UserOption.Verified(),
        UserOption.WithHeld()
    )
}