package com.example.odev7.di

import android.content.Context
import androidx.room.Room
import com.example.odev7.data.datasource.YapilacaklarDataSource
import com.example.odev7.data.repo.YapilacaklarRepository
import com.example.odev7.room.Veritabani
import com.example.odev7.room.YapilacaklarDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideYapilacaklarRepository(yapilacaklarDataSource : YapilacaklarDataSource) : YapilacaklarRepository{
        return YapilacaklarRepository(yapilacaklarDataSource)
    }

    @Provides
    @Singleton
    fun provideYapilacaklarDataSource(yapilacaklarDao: YapilacaklarDao ) : YapilacaklarDataSource {
        return YapilacaklarDataSource(yapilacaklarDao)
    }

    @Provides
    @Singleton
    fun provideYapilacaklarDao(@ApplicationContext context: Context) : YapilacaklarDao{
        val veritabani = Room.databaseBuilder(context,Veritabani::class.java,"yapilacaklar.sqlite")
            .createFromAsset("yapilacaklar.sqlite")
            .build()
        return veritabani.getYapilacaklarDao()
    }
}

