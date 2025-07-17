package com.alanaoliv.apptodo.presentation.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.alanaoliv.apptodo.domain.model.Tarefa

@Composable
fun ListaTarefas(
    tarefas: List<Tarefa>,
    onCheck: (Tarefa, Boolean) -> Unit,
    onEditar: (Tarefa) -> Unit,
    onDeletar: (Tarefa) -> Unit
) {
    LazyColumn {
        items(tarefas) { tarefa ->
            TarefaItem(
                tarefa = tarefa,
                onFeitoChange = { feito -> onCheck(tarefa, feito) },
                onEditar = { onEditar(tarefa) },
                onDeletar = { onDeletar(tarefa) }
            )
        }
    }
}
