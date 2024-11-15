package com.joanDuarte.admobiletest.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SavedArticle(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val title: String,
    val author: String,
    val createdAt: String,
    val url: String,
    var deleted: Boolean
)
