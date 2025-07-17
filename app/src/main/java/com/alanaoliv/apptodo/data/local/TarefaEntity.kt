package com.alanaoliv.apptodo.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tarefas")
data class TarefaEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    var titulo: String,
    var descricao: String?,
    var feito: Boolean = false
)
