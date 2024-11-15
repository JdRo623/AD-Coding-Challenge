package com.joanDuarte.admobiletest.data.local.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.joanDuarte.admobiletest.data.local.model.SavedArticle

@Database(
    entities = [SavedArticle::class],
    version = 1
)
abstract class ArticleDatabase: RoomDatabase() {
    abstract val  articleDao: ArticleDao

    companion object{
        const val DATABASE_NAME = "articles_db"
    }
}