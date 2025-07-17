package com.alanaoliv.apptodo.di

import com.alanaoliv.apptodo.domain.repository.TarefaRepository
import com.alanaoliv.apptodo.domain.usecase.AtualizarEstadoTarefaUseCase
import com.alanaoliv.apptodo.domain.usecase.AtualizarTarefaUseCase
import com.alanaoliv.apptodo.domain.usecase.CriarTarefaUseCase
import com.alanaoliv.apptodo.domain.usecase.DeletarTarefaUseCase
import com.alanaoliv.apptodo.domain.usecase.ListarTodasTarefasUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideCriarTarefaUseCase(repository: TarefaRepository): CriarTarefaUseCase {
        return CriarTarefaUseCase(repository)
    }

    @Provides
    fun provideListarTodasTarefasUseCase(repository: TarefaRepository): ListarTodasTarefasUseCase {
        return ListarTodasTarefasUseCase(repository)
    }

    @Provides
    fun provideAtualizarTarefaUseCase(repository: TarefaRepository): AtualizarTarefaUseCase {
        return AtualizarTarefaUseCase(repository)
    }

    @Provides
    fun provideAtualizarEstadoTarefaUseCase(repository: TarefaRepository): AtualizarEstadoTarefaUseCase {
        return AtualizarEstadoTarefaUseCase(repository)
    }

    @Provides
    fun provideDeletarTarefaUseCase(repository: TarefaRepository): DeletarTarefaUseCase {
        return DeletarTarefaUseCase(repository)
    }
}
