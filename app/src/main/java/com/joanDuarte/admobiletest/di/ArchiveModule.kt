package com.joanDuarte.admobiletest.di

import android.content.Context
import com.joanDuarte.admobiletest.BuildConfig
import com.joanDuarte.admobiletest.domain.article.ArticleRepository
import com.joanDuarte.admobiletest.data.repository.ArticleRepositoryImp
import com.joanDuarte.admobiletest.data.remote.dataSource.ArticleService
import com.joanDuarte.admobiletest.domain.article.LocalArticleDataSource
import com.joanDuarte.admobiletest.domain.article.RemoteArticleDataSource
import com.joanDuarte.admobiletest.data.remote.dataSource.RemoteArticleDataSourceImp
import com.joanDuarte.admobiletest.data.remote.util.ConnectivityObserver
import com.joanDuarte.admobiletest.data.remote.util.NetworkConnectivityObserver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ArchiveModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .build()
    }

    @Provides
    fun providesArticleService(client: OkHttpClient): ArticleService {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ArticleService::class.java)
    }

    @Provides
    fun providesRemoteArticleDataSource(articleService: ArticleService, coroutineScope: CoroutineScope): RemoteArticleDataSource {
        return RemoteArticleDataSourceImp(articleService, coroutineScope)
    }

    @Provides
    fun providesArticleRepository(remoteArticleDataSource: RemoteArticleDataSource,
                                  localArticleDataSource: LocalArticleDataSource
    ): ArticleRepository {
        return ArticleRepositoryImp(remoteArticleDataSource, localArticleDataSource)
    }

    @Provides
    @Singleton
    fun provideNetworkConnectivityObserve(@ApplicationContext appContext: Context): ConnectivityObserver {
        return NetworkConnectivityObserver(appContext)
    }
}