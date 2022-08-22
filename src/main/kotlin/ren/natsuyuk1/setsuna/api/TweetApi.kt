package ren.natsuyuk1.setsuna.api

import io.ktor.client.call.*
import io.ktor.client.request.*
import mu.KotlinLogging
import ren.natsuyuk1.setsuna.SetsunaClient
import ren.natsuyuk1.setsuna.api.options.TweetOption
import ren.natsuyuk1.setsuna.api.options.appendOption
import ren.natsuyuk1.setsuna.api.options.defaultTweetOption
import ren.natsuyuk1.setsuna.consts.TWEET
import ren.natsuyuk1.setsuna.consts.TWITTER_BASE_API
import ren.natsuyuk1.setsuna.response.MultipleTweetFetchResponse
import ren.natsuyuk1.setsuna.response.TweetFetchResponse
import ren.natsuyuk1.setsuna.util.deserializeTo

private val logger = KotlinLogging.logger {}

/**
 * Fetch a single tweet with specific tweet ID.
 *
 * @param tweetID Tweet ID
 * @param options request options, see [TweetOption]
 */
suspend fun SetsunaClient.fetchTweet(
    tweetID: String,
    options: List<TweetOption> = defaultTweetOption
): TweetFetchResponse {
    logger.debug { "Fetching single tweet ($tweetID)" }

    return client.get("$TWITTER_BASE_API$TWEET/$tweetID") {
        appendOption(options)
        appendAuth()
    }.body<String>()
        .deserializeTo()
}

suspend fun SetsunaClient.fetchTweets(
    vararg tweetIDs: String,
    options: List<TweetOption> = defaultTweetOption
): MultipleTweetFetchResponse {
    logger.debug { "Fetching tweets ($tweetIDs)" }

    return client.get("$TWITTER_BASE_API$TWEET") {
        parameter("ids", tweetIDs.encodeToParameter())
        appendOption(options)
        appendAuth()
    }.body<String>()
        .deserializeTo()
}

internal fun Array<out String>.encodeToParameter(): String =
    buildString {
        this@encodeToParameter.forEach {
            append("$it,")
        }
    }.dropLast(1)