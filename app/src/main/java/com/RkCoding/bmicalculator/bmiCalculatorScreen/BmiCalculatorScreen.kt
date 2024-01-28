package com.RkCoding.bmicalculator.bmiCalculatorScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.RkCoding.bmicalculator.bmiCalculatorScreen.component.BmiScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BmiCalculatorScreen(
    state: BmiCalculatorState,
    onEvent: (BmiCalculatorEvent) -> Unit
) {



    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = {
                Text(text = "BMI Calculator")
            })
        }
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = it.calculateTopPadding())
        ) {

            BmiScreen(
                state = state,
                onEvent = onEvent
            )

        }

    }

}


