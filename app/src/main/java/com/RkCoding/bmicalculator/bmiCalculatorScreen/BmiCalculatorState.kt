package com.RkCoding.bmicalculator.bmiCalculatorScreen

data class BmiCalculatorState(
    val sheetTitle: String = "",
    val sheetContent: List<String> = emptyList(),
    val weightUnit: String = "Kilogram",
    val heightUnit: String = "Centimetre"
)


