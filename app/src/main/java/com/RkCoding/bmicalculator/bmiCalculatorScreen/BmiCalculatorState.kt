package com.RkCoding.bmicalculator.bmiCalculatorScreen

data class BmiCalculatorState(
    val weightValue: String = "60.0",
    val heightValue: String = "147",
    val weightValueStage: WeightValueStage = WeightValueStage.INACTIVE,
    val heightValueStage: HeightValueStage = HeightValueStage.INACTIVE,
    val showBmiCard: Boolean = false,
    val sheetTitle: String = "",
    val sheetContent: List<String> = emptyList(),
    val weightUnit: String = "Kilogram",
    val heightUnit: String = "Centimetre"
)


enum class WeightValueStage{
    INACTIVE,
    ACTIVE,
    RUNNING
}

enum class HeightValueStage{
    INACTIVE,
    ACTIVE,
    RUNNING
}


