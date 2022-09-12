package uj

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.doublereceive.*
import uj.plugins.*
import io.ktor.server.application.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        install(DoubleReceive)
        configureRouting()
        configureSerialization()
    }.start(wait = true)
}
