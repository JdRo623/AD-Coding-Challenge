package com.joanDuarte.admobiletest.data.remote.model

data class StoryText(
    val fullyHighlighted: Boolean,
    val matchLevel: String,
    val matchedWords: List<String>,
    val value: String
)