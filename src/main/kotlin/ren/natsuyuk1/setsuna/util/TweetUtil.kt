package ren.natsuyuk1.setsuna.util

internal val tcoPattern: Regex by lazy {
    Regex("https://t.co/[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]")
}

fun String.removeShortLink(): String {
    return replace(tcoPattern.find(this)?.groupValues?.lastOrNull() ?: return this, "")
}