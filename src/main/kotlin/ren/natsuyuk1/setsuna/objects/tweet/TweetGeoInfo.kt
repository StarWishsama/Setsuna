package ren.natsuyuk1.setsuna.objects.tweet

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TweetGeoInfo(
    @SerialName("coordinate")
    val coordinate: Coordinate? = null,
    @SerialName("place_id")
    val placeID: String,
) {
    @Serializable
    data class Coordinate(
        val type: String,
        val coordinates: List<Double>
    )
}