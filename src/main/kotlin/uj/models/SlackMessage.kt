package uj.models

import kotlinx.serialization.Serializable

@Serializable
data class SlackMessage(
    val token: String,
    val team_id: String,
    val api_app_id: String,
    val event: SlackEvent,
    val type: String,
)