package com.RkCoding.bmicalculator.bmiCalculatorScreen

sealed class BmiCalculatorEvent {

    data object WeightClick: BmiCalculatorEvent()
    data object HeightClick: BmiCalculatorEvent()
    data class BottomSheetItemClick(val sheetItem: String): BmiCalculatorEvent()
    data object WeightValueClick: BmiCalculatorEvent()
    data object HeightValueClick: BmiCalculatorEvent()
    data class NumberButtonClick(val number: String): BmiCalculatorEvent()

}