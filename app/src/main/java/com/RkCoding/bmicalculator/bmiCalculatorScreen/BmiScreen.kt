package com.RkCoding.bmicalculator.bmiCalculatorScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.RkCoding.bmicalculator.bmiCalculatorScreen.component.KeyboardButton
import com.RkCoding.bmicalculator.ui.theme.ButtonColor
import com.RkCoding.bmicalculator.ui.theme.Orange

@Composable
fun BmiScreen() {

    val number = listOf("7","8","9","4","5","6","1","2","3","0",".","C")

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            elevation = CardDefaults.cardElevation(4.dp),

        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 4.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "Weight",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )

                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "Arrow Icon"
                )

                Spacer(modifier = Modifier.weight(1f))

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "80.00",
                        fontSize = 45.sp,
                        fontWeight = FontWeight.Bold,
                        color = Orange
                    )

                    Text(
                        text = "Kilogram",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Light,
                        fontStyle = FontStyle.Italic
                    )
                }


            }

        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 4.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "Height",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )

                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "Arrow Icon"
                )

                Spacer(modifier = Modifier.weight(1f))

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "157",
                        fontSize = 45.sp,
                        fontWeight = FontWeight.Bold,
                        color = Orange
                    )

                    Text(
                        text = "Centimeter",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Light,
                        fontStyle = FontStyle.Italic
                    )
                }

            }

        }

        Spacer(modifier = Modifier.weight(1f))

        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp)){

            LazyVerticalGrid(columns = GridCells.Fixed(3),){
                items(number){ number ->
                    KeyboardButton(
                        modifier = Modifier.aspectRatio(1f),
                        number = number,
                        backgroundColor = if (number == "C") Orange else ButtonColor,
                        onNumberClick = {  }
                    )
                }
            }
        }



    }

}


@Preview
@Composable
fun Com() {
    BmiScreen()
}