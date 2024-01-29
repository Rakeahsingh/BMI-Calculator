package com.RkCoding.bmicalculator.bmiCalculatorScreen.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.RkCoding.bmicalculator.ui.theme.CustomBlue
import com.RkCoding.bmicalculator.ui.theme.CustomGreen
import com.RkCoding.bmicalculator.ui.theme.CustomRed
import com.RkCoding.bmicalculator.ui.theme.Orange

@Composable
fun BmiResultCard(
    bmi: Double,
    bmiStage: String = "Normal",
    bmiStageColor: Color = CustomGreen,
    onResetButtonClick: () -> Unit
) {

    Dialog(onDismissRequest = { onResetButtonClick()}
    ) {

        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(15.dp))
                .background(Color.White)
                .border(
                    width = 1.dp,
                    color = Color.Gray,
                    shape = RoundedCornerShape(15.dp)
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
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

            Spacer(modifier = Modifier.height(10.dp))
            Divider(
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .background(Color.Gray)
                    .shadow(elevation = 5.dp),
                thickness = 5.dp
            )

            Text(
                text = "Information",
                fontSize = 20.sp,
                color = Color.Gray,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = 25.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(text = "UnderWeight", color = CustomBlue)
                Text(text = "Normal", color = CustomGreen)
                Text(text = "OverWeight", color = CustomRed)
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(modifier = Modifier.padding(horizontal = 4.dp)) {
                Divider(
                    modifier = Modifier
                        .weight(1f),
                    thickness = 5.dp,
                    color = CustomBlue
                )
                Divider(
                    modifier = Modifier
                        .weight(1f),
                    thickness = 5.dp,
                    color = CustomGreen
                )
                Divider(
                    modifier = Modifier
                        .weight(1f),
                    thickness = 5.dp,
                    color = CustomRed
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp, horizontal = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "16.0", fontSize = 18.sp, color = Color.DarkGray)
                Text(text = "20.0", fontSize = 18.sp, color = Color.DarkGray)
                Text(text = "25.0", fontSize = 18.sp, color = Color.DarkGray)
                Text(text = "30.0", fontSize = 18.sp, color = Color.DarkGray)
            }

            Button(
                onClick = { onResetButtonClick() },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Orange,
                    contentColor = Color.White
                ),
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 8.dp)
                    .bounceClick()
            ) {
                Text(text = "Reset", fontSize = 20.sp)
            }

        }
    }

}

@Preview
@Composable
fun Preview() {
    BmiResultCard(bmi = 0.00){

    }
}