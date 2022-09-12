package uj.models

import kotlinx.serialization.Serializable

@Serializable
data class SlackEvent(
    val type: String,
    val user: String,
    val text: String,
    val ts: String,
    val channel: String,
    val event_ts: String,
)