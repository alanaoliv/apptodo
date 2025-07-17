package com.alanaoliv.apptodo.di

import com.alanaoliv.apptodo.data.repository.TarefaRepositoryImpl
import com.alanaoliv.apptodo.domain.repository.TarefaRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindTarefaRepository(
        tarefaRepositoryImpl: TarefaRepositoryImpl
    ): TarefaRepository
}
