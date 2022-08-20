package ren.natsuyuk1.setsuna

import kotlinx.atomicfu.AtomicRef
import kotlinx.atomicfu.atomic
import kotlinx.serialization.json.Json

/**
 * Represent some config of [SetsunaClient].
 */
object Setsuna {
    /**
     * [Setsuna] default json config
     * You can use `#getAndSet()` to change it.
     */
    val defaultJson: AtomicRef<Json> = atomic(
        Json {
            prettyPrint = true
            isLenient = true
            coerceInputValues = true
        }
    )
}
