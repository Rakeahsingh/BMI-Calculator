package com.RkCoding.bmicalculator.bmiCalculatorScreen

data class BmiCalculatorState(
    val sheetTitle: SheetTitle = SheetTitle.NONE,
    val sheetContent: List<String> = emptyList()
)


enum class SheetTitle{
    WEIGHT,
    HEIGHT,
    NONE
}