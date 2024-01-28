package com.RkCoding.bmicalculator.bmiCalculatorScreen

sealed class BmiCalculatorEvent {

    data object WeightClick: BmiCalculatorEvent()
    data object HeightClick: BmiCalculatorEvent()
    data class BottomSheetItemClick(val sheetItem: String): BmiCalculatorEvent()

}