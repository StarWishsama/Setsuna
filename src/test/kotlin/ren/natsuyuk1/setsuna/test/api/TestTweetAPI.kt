package ren.natsuyuk1.setsuna.test.api

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import ren.natsuyuk1.setsuna.api.fetchTweet
import ren.natsuyuk1.setsuna.api.fetchTweets
import ren.natsuyuk1.setsuna.api.getUserTimeline
import ren.natsuyuk1.setsuna.test.client
import ren.natsuyuk1.setsuna.test.isCI
import ren.natsuyuk1.setsuna.test.print

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestTweetAPI {
    @Test
    fun testSingleTweetFetch() {
        if (isCI) return

        runBlocking {
            client.fetchTweet("1561246803575840769").print()
        }
    }

    @Test
    fun testTweetFetch() {
        if (isCI) return

        runBlocking {
            client.fetchTweets("1561246803575840769", "1559791386152448000").print()
        }
    }

    @Test
    fun testUserTimelineFetch() {
        if (isCI) return

        runBlocking {
            client.getUserTimeline("1315323245306888193").print()
        }
    }
}