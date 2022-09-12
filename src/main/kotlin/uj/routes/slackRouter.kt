package uj.routes

import com.google.gson.Gson
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.json.JSONObject
import uj.models.SlackHello
import uj.models.SlackMessage
import uj.models.SlackText
import uj.service.Categories

val client = HttpClient()
val gson = Gson()
fun Route.slackRouter() {
    route("/") {
        get {
            call.respondText("Hello world!")
        }
        post {
            val receive = call.receiveText()
            val jsonObj = JSONObject(receive)
            if (jsonObj.has("challenge"))
                responseSlackChallenge(call);
            else {
                call.respond(HttpStatusCode.OK)
                onAction((jsonObj["event"] as JSONObject)["type"] as String, call);
            }
        }
    }
}

suspend fun onAction(type: String, call: ApplicationCall) {
    when (type) {
        "app_mention" -> {
            val receive = call.receive<SlackMessage>()
            val textResponse = getResponseForRequest(receive.event.text) ?: return
            val responseEntity = SlackText(receive.event.channel, receive.event.event_ts, textResponse)
            val response: HttpResponse =
                client.post("https://hooks.slack.com/services/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") {
                    contentType(ContentType.Application.Json)
                    setBody(gson.toJson(responseEntity))
                }
        }
    }
}

fun getResponseForRequest(request: String): String? {
    val cmd = request.trim().split(" ")[1];
    val select = request.trim().split(" ").last();
    return when (cmd) {
        "categories" -> "Available categories: " + gson.toJson(Categories().list.map { category -> category.name })
        "items" -> "Items in category $select: " + gson.toJson(Categories().list.find{ category -> category.name ==  select}?.items
            ?: "[]")
        else -> null;
    }
}

suspend fun responseSlackChallenge(call: ApplicationCall) {
    val receive = call.receive<SlackHello>()
    call.respondText(receive.challenge)
}

