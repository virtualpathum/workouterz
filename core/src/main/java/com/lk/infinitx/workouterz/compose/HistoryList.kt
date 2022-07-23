package com.lk.infinitx.workouterz.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lk.infinitx.workouterz.R
import com.lk.infinitx.workouterz.data.entity.History

@Composable
fun HistoryList(
    list : State<List<History>>,
    onCloseTask : (History) -> Unit,
    modifier: Modifier = Modifier
){
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.height(120.dp) ){
        items(
          list.value
        ){ item ->
            HistoryItem(
                name = item.name,
                drawable = item.image,
                date = item.date.toString(),
                onClose = { onCloseTask(item) })
        }
    }
}