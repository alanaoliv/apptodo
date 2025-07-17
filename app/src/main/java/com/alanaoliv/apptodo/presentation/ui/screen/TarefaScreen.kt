package com.alanaoliv.apptodo.presentation.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.alanaoliv.apptodo.domain.model.Tarefa
import com.alanaoliv.apptodo.presentation.ui.components.ListaTarefas
import com.alanaoliv.apptodo.presentation.viewmodel.TarefaViewModel

@Composable
fun TarefaScreen(viewModel: TarefaViewModel = hiltViewModel()) {
    val tarefas by viewModel.tarefas.collectAsState()

    var titulo by remember { mutableStateOf("") }
    var descricao by remember { mutableStateOf("") }
    var tarefaEmEdicao by remember { mutableStateOf<Tarefa?>(null) }

    val editando = tarefaEmEdicao != null

    LaunchedEffect(Unit) {
        viewModel.carregarTarefas()
    }

    Column(modifier = Modifier.padding(16.dp)) {

        OutlinedTextField(
            value = titulo,
            onValueChange = { titulo = it },
            label = { Text("Título da tarefa") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = descricao,
            onValueChange = { descricao = it },
            label = { Text("Descrição") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                if (editando && tarefaEmEdicao != null) {
                    val tarefaAtualizada = tarefaEmEdicao!!.copy(
                        titulo = titulo,
                        descricao = descricao
                    )
                    viewModel.atualizarVTarefa(tarefaAtualizada)
                    tarefaEmEdicao = null
                } else {
                    viewModel.criarNovaTarefa(
                        Tarefa(titulo = titulo, descricao = descricao)
                    )
                }

                titulo = ""
                descricao = ""
            }
        ) {
            Text(if (editando) "Salvar Edição" else "Criar Tarefa")
        }

        Spacer(modifier = Modifier.height(16.dp))


        ListaTarefas(
            tarefas = tarefas,
            onCheck = { tarefa, feito ->
                viewModel.atualizarFeito(tarefa, feito)
            },
            onEditar = { tarefa ->
                tarefaEmEdicao = tarefa
                titulo = tarefa.titulo
                descricao = tarefa.descricao ?: ""
            },
            onDeletar = { tarefa ->
                viewModel.deletarVTarefa(tarefa)
                if (editando && tarefa.id == tarefaEmEdicao?.id) {
                    tarefaEmEdicao = null
                    titulo = ""
                    descricao = ""
                }
            }
        )
    }
}
