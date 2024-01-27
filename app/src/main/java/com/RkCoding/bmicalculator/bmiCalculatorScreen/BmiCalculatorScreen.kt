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
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BmiCalculatorScreen() {

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

            BmiScreen()

        }

    }

}


@Preview(showBackground = true)
@Composable
fun Preview() {
    BmiCalculatorScreen()
}