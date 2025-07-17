package com.alanaoliv.apptodo.domain.repository

import com.alanaoliv.apptodo.domain.model.Tarefa

interface TarefaRepository {
    suspend fun criar(tarefa: Tarefa)
    suspend fun listarTodas(): List<Tarefa>
    suspend fun atualizar(tarefa: Tarefa)
    suspend fun deletar(tarefa: Tarefa)
}
