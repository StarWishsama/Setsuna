package ren.natsuyuk1.setsuna.api

import io.ktor.client.request.*
import io.ktor.client.statement.*
import ren.natsuyuk1.setsuna.SetsunaClient
import ren.natsuyuk1.setsuna.api.options.TweetOption
import ren.natsuyuk1.setsuna.api.options.TwitterOption
import ren.natsuyuk1.setsuna.api.options.appendOption
import ren.natsuyuk1.setsuna.api.options.defaultTwitterOption
import ren.natsuyuk1.setsuna.consts.RETRIEVE_BY_USERNAME
import ren.natsuyuk1.setsuna.consts.RETRIEVE_BY_USERNAMES
import ren.natsuyuk1.setsuna.consts.TWITTER_BASE_API
import ren.natsuyuk1.setsuna.consts.USER
import ren.natsuyuk1.setsuna.response.UserFetchResponse
import ren.natsuyuk1.setsuna.response.UsersFetchResponse
import ren.natsuyuk1.setsuna.util.deserializeResponse
import ren.natsuyuk1.setsuna.util.encodeToParameter

suspend fun SetsunaClient.fetchUser(id: String, twitterOption: List<TwitterOption> = defaultTwitterOption): UserFetchResponse =
    client.get("$TWITTER_BASE_API$USER/$id") {
        appendOption(twitterOption)
        appendAuth()
    }.bodyAsText()
        .deserializeResponse()

suspend fun SetsunaClient.fetchUsers(ids: List<String>, twitterOption: List<TwitterOption> = defaultTwitterOption): UsersFetchResponse =
    client.get("$TWITTER_BASE_API$USER") {
        parameter("ids", ids.encodeToParameter())
        appendOption(twitterOption)
        appendAuth()
    }.bodyAsText()
        .deserializeResponse()

suspend fun SetsunaClient.fetchUserByUsername(username: String, twitterOption: List<TwitterOption> = defaultTwitterOption): UserFetchResponse =
    client.get("$TWITTER_BASE_API$USER$RETRIEVE_BY_USERNAME/$username") {
        appendOption(twitterOption)
        appendAuth()
    }.bodyAsText()
        .deserializeResponse()

suspend fun SetsunaClient.fetchUserByUsernames(vararg usernames: String, twitterOption: List<TwitterOption> = defaultTwitterOption): UsersFetchResponse =
    client.get("$TWITTER_BASE_API$USER$RETRIEVE_BY_USERNAMES") {
        parameter("usernames", usernames.encodeToParameter())
        appendOption(twitterOption)
        appendAuth()
    }.bodyAsText()
        .deserializeResponse()

suspend fun SetsunaClient.getMe(tweetOption: List<TweetOption> = listOf(), twitterOption: List<TwitterOption> = defaultTwitterOption): UserFetchResponse =
    client.get("$TWITTER_BASE_API$USER$RETRIEVE_BY_USERNAMES") {
        appendOption(twitterOption)
        appendAuth()
    }.bodyAsText()
        .deserializeResponse()