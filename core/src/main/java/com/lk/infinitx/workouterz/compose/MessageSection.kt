package com.lk.infinitx.workouterz.compose

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.lk.infinitx.workouterz.R
import java.util.*

@Composable
fun MessageSection(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
    ) {
    Surface(
        shape = MaterialTheme.shapes.small,
        modifier = modifier.fillMaxWidth()
    ){
    Column(
        modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.congratulations).uppercase(Locale.getDefault()),
            style = MaterialTheme.typography.h3,
            modifier = Modifier.fillMaxWidth()
                .paddingFromBaseline(top = 40.dp, bottom = 8.dp),
            color = MaterialTheme.colors.primary,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
        content()
    }
    }
}

@Composable
fun DoneElement(modifier: Modifier) {
    Surface(
        shape = MaterialTheme.shapes.small,
        modifier = modifier
    ) {
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {

            Image(
                painter = painterResource(R.drawable.ic_done),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(88.dp)
                    .clip(CircleShape)
            )
            Text(
                text = stringResource(R.string.done_all),
                style = MaterialTheme.typography.h3,
                modifier = Modifier.padding(horizontal = 16.dp),
                color = Color.Black
            )
        }
    }
}