package com.lk.infinitx.workouterz.compose

import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.lk.infinitx.workouterz.R
import com.lk.infinitx.workouterz.data.entity.History

@Composable
fun HistorySection(list : State<List<History>>,
                  onCloseTask : (History) -> Unit,
                  onClearAllTask : () -> Unit,
                  modifier: Modifier = Modifier
){
    Column {
        HistoryTitleElement(list, modifier, onClearAllTask)

        HistoryList(
            list = list,
            onCloseTask = { item ->
                onCloseTask(item)
            }
        )
    }

}

@Composable
private fun HistoryTitleElement(
    list: State<List<History>>,
    modifier: Modifier,
    onClearAllTask: () -> Unit
) {
    if ((list.value).isNotEmpty()) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(R.string.exercise_history),
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
            OutlinedButton(onClick = { onClearAllTask() }) {
                Text(
                    text = stringResource(R.string.clear_all),
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}