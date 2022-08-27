package ren.natsuyuk1.setsuna.api

import io.ktor.client.request.*
import io.ktor.client.statement.*
import mu.KotlinLogging
import ren.natsuyuk1.setsuna.SetsunaClient
import ren.natsuyuk1.setsuna.api.options.*
import ren.natsuyuk1.setsuna.api.options.appendOption
import ren.natsuyuk1.setsuna.consts.TIMELINE
import ren.natsuyuk1.setsuna.consts.TWEET
import ren.natsuyuk1.setsuna.consts.TWITTER_BASE_API
import ren.natsuyuk1.setsuna.consts.USER
import ren.natsuyuk1.setsuna.response.MultipleTweetFetchResponse
import ren.natsuyuk1.setsuna.response.TweetFetchResponse
import ren.natsuyuk1.setsuna.response.UserTimelineResponse
import ren.natsuyuk1.setsuna.util.deserializeResponse
import ren.natsuyuk1.setsuna.util.encodeToParameter

private val logger = KotlinLogging.logger {}

/**
 * Fetch a single tweet with specific tweet ID.
 *
 * @param tweetID Tweet ID
 * @param tweetOption request options, see [TweetOption]
 */
suspend fun SetsunaClient.fetchTweet(
    tweetID: String,
    tweetOption: List<TweetOption> = defaultTweetOption,
    userOption: List<UserOption> = defaultUserOption,
): TweetFetchResponse {
    logger.debug { "Fetching single tweet ($tweetID)" }

    return client.get("$TWITTER_BASE_API$TWEET/$tweetID") {
        appendOption(tweetOption + userOption)
        appendAuth()
    }.bodyAsText()
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
    tweetOption: List<TweetOption> = defaultTweetOption,
    userOption: List<UserOption> = defaultUserOption,
): MultipleTweetFetchResponse {
    logger.debug { "Fetching tweets (${tweetIDs.toList()})" }

    return client.get("$TWITTER_BASE_API$TWEET") {
        parameter("ids", tweetIDs.encodeToParameter())
        appendOption(tweetOption + userOption)
        appendAuth()
    }.bodyAsText()
        .deserializeResponse()
}

/**
 * Returns Tweets composed by a single user, specified by the requested user ID.
 * By default, the most recent ten Tweets are returned per request.
 * Using pagination, the most recent 3,200 Tweets can be retrieved.
 *
 * @param userID Twitter User ID
 * @param tweetOption [TweetOption]
 */
suspend fun SetsunaClient.getUserTimeline(
    userID: String,
    tweetOption: List<TweetOption> = defaultTweetOption
): UserTimelineResponse {
    logger.debug { "Fetching timeline of user (${userID})" }
    
    return client.get("$TWITTER_BASE_API$USER/$userID$TIMELINE") {
        appendOption(tweetOption)
        appendAuth()
    }.bodyAsText()
        .deserializeResponse()
}