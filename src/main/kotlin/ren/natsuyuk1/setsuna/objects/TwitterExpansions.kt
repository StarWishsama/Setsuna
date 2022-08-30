package ren.natsuyuk1.setsuna.objects

import kotlinx.serialization.Serializable
import ren.natsuyuk1.setsuna.objects.media.Media
import ren.natsuyuk1.setsuna.objects.tweet.Tweet
import ren.natsuyuk1.setsuna.objects.user.TwitterUser

/**
 * @see https://developer.twitter.com/en/docs/twitter-api/expansions
 */
@Serializable
data class TwitterExpansions(
    val media: List<Media>? = null,
    // val places: List<Place>? = null,
    // val topics: List<Topic>? = null,
    val tweets: List<Tweet>? = null,
    val users: List<TwitterUser>? = null,
)