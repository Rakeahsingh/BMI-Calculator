package com.RkCoding.bmicalculator.bmiCalculatorScreen.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BottomSheetContent(
    onCancelClick: () -> Unit,
    sheetContent: List<String>,
    onItemClick: (String) -> Unit
) {


    sheetContent.forEach { item ->
        Text(
            text = item,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            modifier = Modifier.fillMaxWidth()
                .padding(start = 15.dp, top = 8.dp)
                .clickable { onItemClick(item) }
        )
    }



    Button(
        onClick = { onCancelClick() },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Red,
            contentColor = Color.White
        )
    ) {
        Text(
            text = "Cancel",
            fontSize = 18.sp
        )
    }

}