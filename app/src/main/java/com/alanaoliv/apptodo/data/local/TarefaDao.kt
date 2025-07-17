package com.alanaoliv.apptodo.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TarefaDao {
    @Insert
    suspend fun criar(tarefaEntity: TarefaEntity)

    @Query("SELECT * FROM tarefas")
    suspend fun listarTodas(): List<TarefaEntity>

    @Update
    suspend fun atualizar(tarefaEntity: TarefaEntity)

    @Delete
    suspend fun deletar(tarefaEntity: TarefaEntity)
}