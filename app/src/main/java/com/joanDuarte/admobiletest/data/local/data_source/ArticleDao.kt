package com.joanDuarte.admobiletest.data.local.data_source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.joanDuarte.admobiletest.data.local.model.SavedArticle
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleDao {

    @Query("SELECT * FROM savedarticle")
    fun getArticles(): List<SavedArticle>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertArticle(article: SavedArticle)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAllArticles(articles: List<SavedArticle>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateArticle(article: SavedArticle)

}
