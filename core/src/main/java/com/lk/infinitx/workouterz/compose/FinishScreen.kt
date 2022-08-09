package com.lk.infinitx.workouterz.compose

import android.graphics.drawable.BitmapDrawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.unitconverterapp.ui.theme.WorkouterZAppTheme
import com.lk.infinitx.workouterz.R
import com.lk.infinitx.workouterz.presentation.HistoryViewModel




@Composable
fun FinishScreen(
    modifier: Modifier = Modifier,
    vmHistory: HistoryViewModel
){
    val list =  vmHistory.list.collectAsState(initial = emptyList())
       Column(modifier,
            horizontalAlignment = Alignment.CenterHorizontally) {
       // Spacer(Modifier.height(4.dp))
        MessageSection(R.string.congratulations,modifier){
            DoneElement(modifier)
        }

        HistorySection(list = list,
            onCloseTask = {item -> vmHistory.delete(item)},
            onClearAllTask = { vmHistory.deleteAll()})

        Spacer(Modifier.height(4.dp))
    }

}
