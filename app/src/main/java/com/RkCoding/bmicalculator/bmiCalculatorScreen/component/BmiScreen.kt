package com.RkCoding.bmicalculator.bmiCalculatorScreen.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.RkCoding.bmicalculator.bmiCalculatorScreen.BmiCalculatorEvent
import com.RkCoding.bmicalculator.bmiCalculatorScreen.BmiCalculatorState
import com.RkCoding.bmicalculator.bmiCalculatorScreen.BmiCalculatorViewModel
import com.RkCoding.bmicalculator.ui.theme.ButtonColor
import com.RkCoding.bmicalculator.ui.theme.CustomGreen
import com.RkCoding.bmicalculator.ui.theme.Orange

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BmiScreen(
    state: BmiCalculatorState,
    onEvent: (BmiCalculatorEvent) -> Unit
) {

    val context = LocalContext.current

    val number = listOf("7","8","9","4","5","6","1","2","3","0",".","C")

    val modalSheetState = rememberModalBottomSheetState()
    var bottomSheetShow by remember {
        mutableStateOf(false)
    }
    var showDialog by remember {
        mutableStateOf(false)
    }

    if (showDialog){
        BmiResultCard(
            bmi = state.bmi,
            bmiStage = state.bmiStage,
            onResetButtonClick = {
                showDialog = false
            }
        )
    }else {

        if (bottomSheetShow){
        ModalBottomSheet(
            onDismissRequest = { bottomSheetShow = false },
            sheetState = modalSheetState,
            dragHandle = {
                Column(
                    modifier =  Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    BottomSheetDefaults.DragHandle()
                    Text(
                        text = state.sheetTitle,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Divider()
                }
            }
        ) {

            BottomSheetContent(
                onCancelClick = { bottomSheetShow = false },
                sheetContent = state.sheetContent,
                onItemClick = {
                    bottomSheetShow = false
                    onEvent(BmiCalculatorEvent.BottomSheetItemClick(it))
                }
            )

        }
    }

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

                IconButton(
                    onClick = {
                        bottomSheetShow = true
                        onEvent(BmiCalculatorEvent.WeightClick)
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow Icon"
                    )
                }


                Spacer(modifier = Modifier.weight(1f))

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = state.weightValue,
                        fontSize = 45.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Red,
                        modifier = Modifier.clickable(
                            interactionSource = MutableInteractionSource(),
                            indication = null,
                            onClick = {
                                onEvent(BmiCalculatorEvent.WeightValueClick)
                            }
                        )
                    )

                    Text(
                        text = state.weightUnit,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        color = Orange
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

                IconButton(
                    onClick = {
                        bottomSheetShow = true
                        onEvent(BmiCalculatorEvent.HeightClick)
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow Icon"
                    )
                }



                Spacer(modifier = Modifier.weight(1f))

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = state.heightValue,
                        fontSize = 45.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Red,
                        modifier = Modifier.clickable(
                            interactionSource = MutableInteractionSource(),
                            indication = null,
                            onClick = {
                                onEvent(BmiCalculatorEvent.HeightValueClick)
                            }
                        )
                    )


                    Text(
                        text = state.heightUnit,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        color = Orange
                    )
                }

            }

        }

        Spacer(modifier = Modifier.weight(1f))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 8.dp)
        ) {

            LazyVerticalGrid(
                modifier = Modifier.padding(horizontal = 30.dp, vertical = 12.dp),
                columns = GridCells.Fixed(3)
            ) {
                items(number) { number ->
                    KeyboardButton(
                        modifier = Modifier
                            .aspectRatio(1f)
                            .bounceClick(),
                        number = number,
                        backgroundColor = if (number == "C") Orange else ButtonColor,
                        onNumberClick = {
                            onEvent(BmiCalculatorEvent.NumberButtonClick(it))
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = {
                showDialog = true
                onEvent(BmiCalculatorEvent.GoButtonClick(context))
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = CustomGreen,
                contentColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
                .bounceClick()
        ) {
            Text(
                text = "Submit Bmi",
                fontSize = 20.sp
            )
        }
      }

    }

}


@Preview
@Composable
fun Pre() {
    val viewModel = viewModel<BmiCalculatorViewModel>()
    val state by viewModel.state.collectAsState()
   BmiScreen(state = state, onEvent = viewModel::onEvent)
}

