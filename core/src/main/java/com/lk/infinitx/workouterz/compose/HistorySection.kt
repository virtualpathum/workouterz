package com.lk.infinitx.workouterz.compose

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.lk.infinitx.workouterz.R
import com.lk.infinitx.workouterz.data.entity.History

@Composable
fun HistorySection(list : State<List<History>>,
                  onCloseTask : (History) -> Unit,
                  onClearAllTask : () -> Unit,
                  modifier: Modifier = Modifier
){
    Surface(
        shape = MaterialTheme.shapes.small,
        modifier = modifier
    ) {
        Column {
            HistoryTitleElement(list, modifier, onClearAllTask)
            Spacer(Modifier.height(4.dp))
            if(list.value.isNotEmpty()) {
                HistoryList(
                    list = list,
                    onCloseTask = { item ->
                        onCloseTask(item)
                    }
                )
            }else{
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth().heightIn(50.dp)
                    ) {
                        Text(
                            text = "No Data Available",
                            color = Color.Black,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    }
                }
        }
    }

}

@Composable
private fun HistoryTitleElement(
    list: State<List<History>>,
    modifier: Modifier,
    onClearAllTask: () -> Unit
) {
        Surface(
            shape = MaterialTheme.shapes.small,
            modifier = modifier.padding(10.dp)
        ) {
            //Card(elevation = 10.dp, modifier = Modifier.padding(10.dp)) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {

                Text(
                    text = stringResource(R.string.exercise_history),
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
                if ((list.value).isNotEmpty()) {
                    OutlinedButton(onClick = { onClearAllTask() }) {
                        Text(
                            text = stringResource(R.string.clear_all),
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
           // }

    }
}