package com.lk.infinitx.workouterz.compose

import android.graphics.drawable.BitmapDrawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.lk.infinitx.workouterz.R
import com.lk.infinitx.workouterz.presentation.HistoryViewModel
import com.lk.infinitx.workouterz.presentation.HistoryViewModelFactory

@Composable
fun FinishScreen(
    vmfHistory : HistoryViewModelFactory,
    vmHistory: HistoryViewModel = viewModel(factory = vmfHistory),
    modifier: Modifier = Modifier,
    onClearAllTask : () -> Unit
){

    val list = vmHistory.getHistory()
    Column(modifier = modifier.padding(30.dp)) {

        Text(text = "Done",
        color = Color.Green)

        Card(
            modifier = Modifier.size(48.dp),
            shape = CircleShape,
            elevation = 2.dp
        ) {
            Image(
                painterResource(R.drawable.ic_done),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        OutlinedButton(onClick = { onClearAllTask() }) {
            Text(
                text = "Finish",
                color = Color.Gray
            )
        }

    }

}