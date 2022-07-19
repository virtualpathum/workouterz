package com.lk.infinitx.workouterz.compose

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import com.lk.infinitx.workouterz.data.entity.History

@Composable
fun HistoryList(
    list : State<List<History>>,
    onCloseTask : (History) -> Unit,
    modifier: Modifier = Modifier
){
    LazyColumn{
        items(
          list.value
        ){ item ->
            HistoryItem(
                id = item.id,
                name = item.exerciseName,
                date = item.date.toString(),
                onClose = { onCloseTask(item) })
        }
    }
}