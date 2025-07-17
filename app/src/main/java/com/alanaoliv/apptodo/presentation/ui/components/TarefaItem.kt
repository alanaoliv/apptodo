package com.alanaoliv.apptodo.presentation.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.alanaoliv.apptodo.domain.model.Tarefa

@Composable
fun TarefaItem(
    tarefa: Tarefa,
    onFeitoChange: (Boolean) -> Unit,
    onEditar: () -> Unit,
    onDeletar: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = tarefa.feito,
            onCheckedChange = onFeitoChange
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = tarefa.titulo,
                style = if (tarefa.feito) {
                    TextStyle(textDecoration = TextDecoration.LineThrough)
                } else {
                    LocalTextStyle.current
                }
            )

            tarefa.descricao?.let { descricao ->
                Text(text = descricao)
            }
        }

        IconButton(onClick = onEditar) {
            Icon(Icons.Default.Edit, contentDescription = "Editar")
        }

        IconButton(onClick = onDeletar) {
            Icon(Icons.Default.Delete, contentDescription = "Deletar")
        }
    }
}
