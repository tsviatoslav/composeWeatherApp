package com.example.composeweatherapp

import java.util.*

data class TodoItem(
    val task: String,
    // since the user may generate identical tasks, give them each a unique ID
    val id: UUID = UUID.randomUUID()
)