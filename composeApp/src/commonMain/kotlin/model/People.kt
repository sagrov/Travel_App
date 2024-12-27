package model

import org.jetbrains.compose.resources.DrawableResource

data class People (
    val id: Int,
    val title: String,
    val image: DrawableResource
)