package com.alanaoliv.apptodo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alanaoliv.apptodo.domain.model.Tarefa
import com.alanaoliv.apptodo.presentation.ui.components.TarefaItem
import com.alanaoliv.apptodo.presentation.ui.screen.TarefaScreen
import com.alanaoliv.apptodo.ui.theme.ApptodoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ApptodoTheme {
                TarefaScreen()
            }
        }
    }
}



@Composable
fun TarefaScreenPreview(tarefas: List<Tarefa>) {
    Column(modifier = Modifier.padding(16.dp)) {
        tarefas.forEach { tarefa ->
            TarefaItem(
                tarefa = tarefa,
                onFeitoChange = {},
                onEditar = {}
            ) {}
        }
    }
}



