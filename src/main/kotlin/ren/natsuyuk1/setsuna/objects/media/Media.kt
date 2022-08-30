package ren.natsuyuk1.setsuna.objects.media

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Media refers to any image, GIF, or video attached to a Tweet.
 * The media object is not a primary object on any endpoint,
 * but can be found and expanded in the Tweet object.
 *
 */
@Serializable
data class Media(
    /**
     * Unique identifier of the expanded media content.
     */
    @SerialName("media_key")
    val mediaKey: String,
    /**
     * Type of content (animated_gif, photo, video).
     */
    @SerialName("type")
    val type: MediaType,
    /**
     * A direct URL to the media file on Twitter.
     */
    @SerialName("url")
    val url: String? = null,
    /**
     * Available when type is video. Duration in **milliseconds** of the video.
     */
    @SerialName("duration_ms")
    val duration: Int? = null,
    /**
     * Height of this content in pixels.
     */
    @SerialName("height")
    val height: Int? = null,
    /**
     * Width of this content in pixels.
     */
    @SerialName("width")
    val width: Int? = null,
    /**
     * Non-public engagement metrics for the media content at the time of the request.
     *
     * **Requires** user context authentication.
     */
    @SerialName("non_public_metrics")
    val nonPublicMetrics: MediaNonPublicMetrics? = null,
    /**
     * Engagement metrics for the media content, tracked in an organic context, at the time of the request.
     *
     * **Requires** user context authentication.
     */
    @SerialName("organic_metrics")
    val organicMetrics: MediaMetrics? = null,
    /**
     * URL to the static placeholder preview of this content.
     */
    @SerialName("preview_image_url")
    val previewImageURL: String? = null,
    /**
     * Engagement metrics for the media content, tracked in a promoted context,
     * at the time of the request.
     */
    @SerialName("promoted_metrics")
    val promotedMetrics: MediaMetrics? = null,
    /**
     * Public engagement metrics for the media content at the time of the request.
     */
    @SerialName("public_metrics")
    val publicMetrics: MediaPublicMetrics? = null,
    /**
     * A description of an image to enable and support accessibility.
     * Can be up to 1000 characters long.
     * Alt text can only be added to images at the moment.
     */
    @SerialName("alt_text")
    val altText: String? = null,
    @SerialName("variants")
    val variants: List<MediaVariant>? = null,
) {
    @Serializable
    data class MediaNonPublicMetrics(
        @SerialName("playback_0_count")
        val playbackNoneCount: Int,
        @SerialName("playback_25_count")
        val playbackQuarterCount: Int,
        @SerialName("playback_50_count")
        val playbackHalfCount: Int,
        @SerialName("playback_75_count")
        val playbackThreeQuarterCount: Int,
        @SerialName("playback_100_count")
        val playbackFinishCount: Int,
    )

    @Serializable
    data class MediaPublicMetrics(
        @SerialName("view_count")
        val view: Int
    )

    @Serializable
    data class MediaMetrics(
        @SerialName("playback_0_count")
        val playbackNoneCount: Int,
        @SerialName("playback_25_count")
        val playbackQuarterCount: Int,
        @SerialName("playback_50_count")
        val playbackHalfCount: Int,
        @SerialName("playback_75_count")
        val playbackThreeQuarterCount: Int,
        @SerialName("playback_100_count")
        val playbackFinishCount: Int,
        @SerialName("view_count")
        val view: Int
    )

    @Serializable
    data class MediaVariant(
        @SerialName("bit_rate")
        val bitRate: Int? = null,
        @SerialName("content_type")
        val contentType: String? = null,
        @SerialName("url")
        val url: String? = null
    )
}

@Serializable
enum class MediaType {
    @SerialName("animated_gif")
    GIF,
    @SerialName("photo")
    PHOTO,
    @SerialName("video")
    VIDEO
}