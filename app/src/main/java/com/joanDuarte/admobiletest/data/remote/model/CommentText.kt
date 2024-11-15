package com.joanDuarte.admobiletest.data.remote.model

data class CommentText(
    val fullyHighlighted: Boolean,
    val matchLevel: String,
    val matchedWords: List<String>,
    val value: String
)