package ren.natsuyuk1.setsuna.api

import io.ktor.client.request.*
import io.ktor.client.statement.*
import mu.KotlinLogging
import ren.natsuyuk1.setsuna.SetsunaClient
import ren.natsuyuk1.setsuna.api.options.TwitterOption
import ren.natsuyuk1.setsuna.api.options.appendOption
import ren.natsuyuk1.setsuna.api.options.defaultTwitterOption
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
 * @param twitterOption request options, see [TwitterOption]
 */
suspend fun SetsunaClient.fetchTweet(
    tweetID: String,
    twitterOption: List<TwitterOption> = defaultTwitterOption,
): TweetFetchResponse {
    logger.debug { "Fetching single tweet ($tweetID)" }

    return client.get("$TWITTER_BASE_API$TWEET/$tweetID") {
        appendOption(twitterOption)
        appendAuth()
    }.bodyAsText()
        .deserializeResponse()
}

/**
 * Fetch tweets with specific tweet IDs.
 *
 * @param tweetIDs Tweet IDs
 * @param twitterOption request options, see [TwitterOption]
 */
suspend fun SetsunaClient.fetchTweets(
    vararg tweetIDs: String,
    twitterOption: List<TwitterOption> = defaultTwitterOption,
): MultipleTweetFetchResponse {
    logger.debug { "Fetching tweets (${tweetIDs.toList()})" }

    return client.get("$TWITTER_BASE_API$TWEET") {
        parameter("ids", tweetIDs.encodeToParameter())
        appendOption(twitterOption)
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
 * @param twitterOption request options, see [TwitterOption]
 */
suspend fun SetsunaClient.getUserTimeline(
    userID: String,
    twitterOption: List<TwitterOption> = defaultTwitterOption
): UserTimelineResponse {
    logger.debug { "Fetching timeline of user (${userID})" }
    
    return client.get("$TWITTER_BASE_API$USER/$userID$TIMELINE") {
        appendOption(twitterOption)
        appendAuth()
    }.bodyAsText()
        .deserializeResponse()
}