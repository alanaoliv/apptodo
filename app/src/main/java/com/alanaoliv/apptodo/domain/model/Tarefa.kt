package com.alanaoliv.apptodo.domain.model

data class Tarefa(
    val id: Int = 0,
    var titulo: String,
    var descricao: String?,
    var feito: Boolean = false
)
