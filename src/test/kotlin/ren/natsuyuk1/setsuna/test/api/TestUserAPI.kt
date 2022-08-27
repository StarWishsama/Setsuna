package ren.natsuyuk1.setsuna.test.api

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import ren.natsuyuk1.setsuna.api.fetchUserByUsername
import ren.natsuyuk1.setsuna.test.client
import ren.natsuyuk1.setsuna.test.isCI
import kotlin.test.assertEquals

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestUserAPI {
    @Test
    fun testUserIDFetch() {
        if (isCI) return

        runBlocking {
            assertEquals("1315323245306888193", client.fetchUserByUsername("noraincity_").user?.id)
        }
    }
}