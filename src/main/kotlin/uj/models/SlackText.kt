package uj.models
import kotlinx.serialization.Serializable

@Serializable
data class SlackText(val channel: String,val thread_ts: String,val text: String)
