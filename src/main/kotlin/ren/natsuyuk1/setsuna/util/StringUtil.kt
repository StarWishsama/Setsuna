package ren.natsuyuk1.setsuna.util

internal fun Array<out String>.encodeToParameter(): String =
    buildString {
        this@encodeToParameter.forEach {
            append("$it,")
        }
    }.dropLast(1)

internal fun List<String>.encodeToParameter(): String =
    buildString {
        this@encodeToParameter.forEach {
            append("$it,")
        }
    }.dropLast(1)