package ren.natsuyuk1.setsuna.api

import io.ktor.client.call.*
import io.ktor.client.request.*
import mu.KotlinLogging
import ren.natsuyuk1.setsuna.SetsunaClient
import ren.natsuyuk1.setsuna.api.options.TweetOption
import ren.natsuyuk1.setsuna.api.options.appendTweetOption
import ren.natsuyuk1.setsuna.api.options.defaultTweetOption
import ren.natsuyuk1.setsuna.consts.TWEET
import ren.natsuyuk1.setsuna.consts.TWITTER_BASE_API
import ren.natsuyuk1.setsuna.response.MultipleTweetFetchResponse
import ren.natsuyuk1.setsuna.response.TweetFetchResponse
import ren.natsuyuk1.setsuna.util.deserializeResponse

private val logger = KotlinLogging.logger {}

/**
 * Fetch a single tweet with specific tweet ID.
 *
 * @param tweetID Tweet ID
 * @param tweetOption request options, see [TweetOption]
 */
suspend fun SetsunaClient.fetchTweet(
    tweetID: String,
    tweetOption: List<TweetOption> = defaultTweetOption
): TweetFetchResponse {
    logger.debug { "Fetching single tweet ($tweetID)" }

    return client.get("$TWITTER_BASE_API$TWEET/$tweetID") {
        appendTweetOption(tweetOption)
        appendAuth()
    }.body<String>()
        .deserializeResponse()
}

/**
 * Fetch tweets with specific tweet IDs.
 *
 * @param tweetIDs Tweet IDs
 * @param tweetOption request options, see [TweetOption]
 */
suspend fun SetsunaClient.fetchTweets(
    vararg tweetIDs: String,
    tweetOption: List<TweetOption> = defaultTweetOption
): MultipleTweetFetchResponse {
    logger.debug { "Fetching tweets (${tweetIDs.toList()})" }

    return client.get("$TWITTER_BASE_API$TWEET") {
        parameter("ids", tweetIDs.encodeToParameter())
        appendTweetOption(tweetOption)
        appendAuth()
    }.body<String>()
        .deserializeResponse()
}

internal fun Array<out String>.encodeToParameter(): String =
    buildString {
        this@encodeToParameter.forEach {
            append("$it,")
        }
    }.dropLast(1)