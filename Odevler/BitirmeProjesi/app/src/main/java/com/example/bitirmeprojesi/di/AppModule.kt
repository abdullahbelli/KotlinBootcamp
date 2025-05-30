package com.example.bitirmeprojesi.di

import com.example.bitirmeprojesi.data.datasource.YemeklerDataSource
import com.example.bitirmeprojesi.data.repo.YemeklerRepository
import com.example.bitirmeprojesi.retrofit.ApiUtils
import com.example.bitirmeprojesi.retrofit.YemeklerDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideYemeklerRepository(yemeklerDataSource: YemeklerDataSource) : YemeklerRepository{
        return YemeklerRepository(yemeklerDataSource)
    }

    @Provides
    @Singleton
    fun provideYemeklerDataSource(yemeklerDao: YemeklerDao) : YemeklerDataSource{
        return YemeklerDataSource(yemeklerDao)
    }

    @Provides
    @Singleton
    fun provideYemeklerDao() : YemeklerDao{
        return ApiUtils.getYemeklerDAO()
    }
}