package ren.natsuyuk1.setsuna.util

import kotlinx.serialization.SerializationException
import kotlinx.serialization.decodeFromString
import mu.KotlinLogging
import ren.natsuyuk1.setsuna.Setsuna

private val logger = KotlinLogging.logger {}

internal inline fun <reified T> String.deserializeTo(): T {
    logger.trace { "Received raw json: $this" }
    return try {
        Setsuna.defaultJson.value.decodeFromString(this)
    } catch (e: SerializationException) {
        logger.error { "Failed to deserialize, raw json: $this" }
        throw e
    }
}
