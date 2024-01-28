package com.RkCoding.bmicalculator.bmiCalculatorScreen.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.RkCoding.bmicalculator.ui.theme.CustomGreen
import com.RkCoding.bmicalculator.ui.theme.Orange

@Composable
fun BmiResultCard(
    bmi: Double,
    bmiStage: String = "Normal",
    bmiStageColor: Color = CustomGreen
) {

    Column(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = Color.Gray,
                shape = RoundedCornerShape(15.dp)
            )
            .clip(RoundedCornerShape(15.dp)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Row (
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "$bmi",
                fontSize = 70.sp,
                color = Orange
            )

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "BMI",
                    fontSize = 40.sp,
                    color = Color.Gray
                )
                Text(
                    text = bmiStage,
                    fontSize = 18.sp,
                    color = bmiStageColor
                )
            }

        }

    }

}