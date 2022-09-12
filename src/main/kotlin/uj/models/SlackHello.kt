package uj.models
import kotlinx.serialization.Serializable

@Serializable
data class SlackHello(val token: String, val challenge: String, val type: String)
