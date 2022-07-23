package com.lk.infinitx.workouterz.compose

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.lk.infinitx.workouterz.R

@Composable
fun WorkouterzBottomNavigation(
    modifier: Modifier = Modifier,
    onClick:() -> Unit) {
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background,
        modifier = modifier) {
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = null
                )
            },
            label = {
                Text(stringResource(R.string.bottom_navigation_home))
            },
            selected = true,
            onClick = {onClick}
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null
                )
            },
            label = {
                Text(stringResource(R.string.bottom_navigation_profile))
            },
            selected = false,
            onClick = {onClick}
        )
    }
}