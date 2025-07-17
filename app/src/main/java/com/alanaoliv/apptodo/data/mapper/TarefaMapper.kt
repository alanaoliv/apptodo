package com.alanaoliv.apptodo.data.mapper

import com.alanaoliv.apptodo.data.local.TarefaEntity
import com.alanaoliv.apptodo.domain.model.Tarefa

fun TarefaEntity.toDomain(): Tarefa {
    return Tarefa(
        id = this.id,
        titulo = this.titulo,
        descricao = this.descricao,
        feito = this.feito
    )
}

fun Tarefa.toEntity(): TarefaEntity {
    return TarefaEntity(
        id = this.id,
        titulo = this.titulo,
        descricao = this.descricao,
        feito = this.feito
    )
}
