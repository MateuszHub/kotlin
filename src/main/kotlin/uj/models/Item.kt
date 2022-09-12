package uj.models

import kotlinx.serialization.Serializable

@Serializable
data class Item(
    val Id: Int,
    val Name: String,
    val Price: Int
)
