package com.joanDuarte.admobiletest.di

import android.app.Application
import androidx.room.Room
import com.joanDuarte.admobiletest.data.local.data_source.ArticleDatabase
import com.joanDuarte.admobiletest.domain.article.LocalArticleDataSource
import com.joanDuarte.admobiletest.data.local.data_source.LocalArticleDataSourceImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {
    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): ArticleDatabase {
        return Room.databaseBuilder(
            app,
            ArticleDatabase::class.java,
            ArticleDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideLocalArticleDataSource(db: ArticleDatabase, coroutineScope: CoroutineScope): LocalArticleDataSource {
        return LocalArticleDataSourceImp(db.articleDao, coroutineScope)
    }

    @Provides
    @Singleton
    fun provideApplicationScope(): CoroutineScope {
       // return (Applica as ArticleApp).applicationScope
        return CoroutineScope(SupervisorJob())
    }

}