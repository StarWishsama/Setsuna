package ren.natsuyuk1.setsuna.api

import io.ktor.client.call.*
import io.ktor.client.request.*
import ren.natsuyuk1.setsuna.SetsunaClient
import ren.natsuyuk1.setsuna.consts.TWITTER_BASE_API
import ren.natsuyuk1.setsuna.consts.USER
import ren.natsuyuk1.setsuna.response.UserFetchResponse
import ren.natsuyuk1.setsuna.util.deserializeResponse

suspend fun SetsunaClient.fetchSingleUser(id: Long): UserFetchResponse =
    client.get("$TWITTER_BASE_API$USER/$id") {
        appendAuth()
    }.body<String>()
        .deserializeResponse()