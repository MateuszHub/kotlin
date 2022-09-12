package uj.plugins

import io.ktor.server.routing.*
import io.ktor.server.application.*
import uj.routes.slackRouter

fun Application.configureRouting() {

    // Starting point for a Ktor app:
    routing {
        slackRouter()
    }
}
