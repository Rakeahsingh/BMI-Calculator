package com.RkCoding.bmicalculator.bmiCalculatorScreen.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun KeyboardButton(
    modifier: Modifier = Modifier,
    number: String,
    backgroundColor: Color,
    onNumberClick: (String) -> Unit
) {

    Box(
        modifier = modifier
            .padding(8.dp)
            .clip(CircleShape)
            .background(backgroundColor)
            .clickable { onNumberClick(number) },
        contentAlignment = Alignment.Center
    ){
        Text(
            text = number,
            fontSize = 32.sp
        )
    }

}