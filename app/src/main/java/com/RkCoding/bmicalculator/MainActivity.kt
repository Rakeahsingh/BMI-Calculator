package com.RkCoding.bmicalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.RkCoding.bmicalculator.bmiCalculatorScreen.BmiCalculatorScreen
import com.RkCoding.bmicalculator.bmiCalculatorScreen.BmiCalculatorViewModel
import com.RkCoding.bmicalculator.ui.theme.BMICalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BMICalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val viewModel = viewModel<BmiCalculatorViewModel>()
                    val state by viewModel.state.collectAsState()

                    BmiCalculatorScreen(
                        state = state,
                        onEvent = viewModel::onEvent
                    )

                }
            }
        }
    }
}

