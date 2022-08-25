package ren.natsuyuk1.setsuna.test.api

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import ren.natsuyuk1.setsuna.api.fetchTweet
import ren.natsuyuk1.setsuna.api.fetchTweets
import ren.natsuyuk1.setsuna.test.client
import ren.natsuyuk1.setsuna.test.isCI
import ren.natsuyuk1.setsuna.test.print

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestTweetAPI {
    @Test
    fun testSingleTweetFetch() {
        if (isCI) return

        runBlocking {
            client.fetchTweet("1561246803575840769", emptyList()).print()
        }
    }

    @Test
    fun testTweetFetch() {
        if (isCI) return

        runBlocking {
            client.fetchTweets("1561246803575840769", "1559791386152448000").print()
        }
    }
}