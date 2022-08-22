package ren.natsuyuk1.setsuna.objects

import kotlinx.serialization.Serializable
import ren.natsuyuk1.setsuna.objects.tweet.Tweet

@Serializable
data class TwitterExpansions(
    // val media: List<Media>? = null,
    // val places: List<Place>? = null,
    // val topics: List<Topic>? = null,
    val tweets: List<Tweet>? = null,
    // val users: List<User>? = null,
)