package com.alanaoliv.apptodo.data.repository

import com.alanaoliv.apptodo.data.local.TarefaDao
import com.alanaoliv.apptodo.data.mapper.toDomain
import com.alanaoliv.apptodo.data.mapper.toEntity
import com.alanaoliv.apptodo.domain.model.Tarefa
import com.alanaoliv.apptodo.domain.repository.TarefaRepository
import javax.inject.Inject

class TarefaRepositoryImpl @Inject constructor(
    private val tarefaDao: TarefaDao
) : TarefaRepository {

    override suspend fun criar(tarefa: Tarefa) {
        tarefaDao.criar(tarefa.toEntity())
    }

    override suspend fun listarTodas(): List<Tarefa> {
        return tarefaDao.listarTodas().map { it.toDomain() }
    }

    override suspend fun atualizar(tarefa: Tarefa) {
        tarefaDao.atualizar(tarefa.toEntity())
    }

    override suspend fun deletar(tarefa: Tarefa) {
        tarefaDao.deletar(tarefa.toEntity())
    }
}
