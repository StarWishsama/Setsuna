package ren.natsuyuk1.setsuna.test

import ren.natsuyuk1.setsuna.SetsunaClient
import java.io.File

internal val token = File("./token").readText()

internal val client = SetsunaClient(bearerToken = token)

internal fun Any?.print() = println(this)