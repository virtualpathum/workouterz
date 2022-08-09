package com.lk.infinitx.workouterz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.unitconverterapp.ui.theme.WorkouterZAppTheme
import com.lk.infinitx.workouterz.compose.FinishScreen
import com.lk.infinitx.workouterz.compose.WorkouterzBottomNavigation
import com.lk.infinitx.workouterz.databinding.ActivityFinishBinding
import com.lk.infinitx.workouterz.presentation.HistoryViewModel
//import com.lk.infinitx.workouterz.presentation.HistoryViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FinishActivity : ComponentActivity() {
    private lateinit var binding: ActivityFinishBinding

    private val vmHistory: HistoryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
       /* binding = ActivityFinishBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.toolbarFinishActivity.setNavigationOnClickListener {
            onBackPressed()
        }

        binding.btnFinish.setOnClickListener {

            throw RuntimeException("Test Crash")
           // finish()
        }*/

        setContent {
            launchFinishScreen()
        }
    }

    @Composable
    fun launchFinishScreen(){
        WorkouterZAppTheme() {
            Scaffold(
                bottomBar = {
                    WorkouterzBottomNavigation(){
                        finish()
                    }
                }
            ) {
                FinishScreen(Modifier.padding(5.dp),vmHistory)
            }
        }
    }
}