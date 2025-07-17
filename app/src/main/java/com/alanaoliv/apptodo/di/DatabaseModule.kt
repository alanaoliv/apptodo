package com.alanaoliv.apptodo.di

import android.content.Context
import androidx.room.Room
import com.alanaoliv.apptodo.data.local.TarefaDao
import com.alanaoliv.apptodo.data.local.TarefaDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext appContext: Context
    ): TarefaDatabase {
        return Room.databaseBuilder(
            appContext,
            TarefaDatabase::class.java,
            "tarefas_db"
        ).build()
    }

    @Singleton
    @Provides
    fun provideTarefaDao(database: TarefaDatabase): TarefaDao {
        return database.tarefaDao()
    }
}