package com.trab.jetpackson2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.compose.foundation.Icon
import androidx.compose.ui.platform.setContent
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.viewModel
import androidx.lifecycle.LiveData

class MainActivity : AppCompatActivity() {
    val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test(mainViewModel.soma)
        }
    }

    @Composable
    fun Test(somaData: LiveData<Int>) {
        val soma: Int? by somaData.observeAsState()
        Scaffold (
            topBar = {},
            bodyContent = {
                Column(
                    modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(soma.toString())
                }
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        mainViewModel.increment(1)
                    }
                ) {
                    Icon(Icons.Filled.Add)
                }
            }
        )
    }
}