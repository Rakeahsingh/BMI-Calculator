package com.RkCoding.bmicalculator.bmiCalculatorScreen

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.math.roundToInt

class BmiCalculatorViewModel: ViewModel() {

    private val _state = MutableStateFlow(BmiCalculatorState())
    val state = _state.asStateFlow()


    fun onEvent(event: BmiCalculatorEvent){
        when(event){
            is BmiCalculatorEvent.HeightClick -> {
                _state.update {
                    it.copy(
                        sheetTitle = "Height",
                        sheetContent = listOf("Centimeter", "Meter", "Feet", "Inches")
                    )
                }
            }

            is BmiCalculatorEvent.WeightClick -> {
                _state.update {
                    it.copy(
                        sheetTitle = "Weight",
                        sheetContent = listOf("Kilogram", "Pounds")
                    )
                }
            }

            is BmiCalculatorEvent.BottomSheetItemClick -> {
                weightAndHeightUnitChange(sheetItem = event.sheetItem)
            }

            is BmiCalculatorEvent.HeightValueClick -> {
                _state.update {
                    it.copy(
                        heightValueStage = HeightValueStage.ACTIVE,
                        weightValueStage = WeightValueStage.INACTIVE,
                        showBmiCard = false
                    )
                }
            }

            is BmiCalculatorEvent.WeightValueClick -> {
                _state.update {
                    it.copy(
                        weightValueStage = WeightValueStage.ACTIVE,
                        heightValueStage = HeightValueStage.INACTIVE,
                        showBmiCard = false
                    )
                }
            }

            is BmiCalculatorEvent.NumberButtonClick -> {
                enterNumber(event.number)
            }

            is BmiCalculatorEvent.GoButtonClick -> {
                calculateBmi(event.context)
            }
        }
    }

    private fun calculateBmi(context: Context) {
        val weightInKgs: Double = when(_state.value.weightUnit){
            "Pounds" -> _state.value.weightValue.toDouble().times(0.4536)
            else -> _state.value.weightValue.toDouble()
        }

        val heightInMeter: Double = when(_state.value.heightUnit){
            "Centimeter" -> _state.value.heightValue.toDouble().times(0.1)
            "Feet" -> _state.value.heightValue.toDouble().times(0.3048)
            "Inches" -> _state.value.heightValue.toDouble().times(0.0254)
            else -> _state.value.heightValue.toDouble()
        }

        try {
            val bmiValue = weightInKgs / (heightInMeter * heightInMeter)
            val bmiValueWithDecimal = (bmiValue * 10).roundToInt() / 10.0
            val bmiStage = when(bmiValueWithDecimal){
                in 0.0..18.5 -> "UnderWeight"
                in 18.5..25.0 -> "Normal"
                in 25.0..100.0 -> "OverWeight"
                else -> "Invalid"
            }
            _state.update {
                it.copy(
                    showBmiCard = true,
                    bmi = if (bmiValueWithDecimal > 100) 0.0 else bmiValueWithDecimal,
                    bmiStage = bmiStage
                )
            }

        }catch (e: Exception){
            Toast.makeText(context,
                "This BMI does not look good, check again the height and weight value",
                Toast.LENGTH_SHORT).show()
        }
    }

    private fun enterNumber(number: String) {
        when{
            _state.value.weightValueStage == WeightValueStage.ACTIVE -> {
                _state.update {
                    it.copy(
                        weightValue = when(number){
                            "." -> "0"
                            "C" -> "0"
                            else -> number
                        },
                        weightValueStage = WeightValueStage.RUNNING
                    )
                }
            }
            _state.value.weightValueStage == WeightValueStage.RUNNING -> {
                if (_state.value.weightValue.contains(".").not()
                    && _state.value.weightValue.contains("C").not()
                    && _state.value.weightValue.length <= 3
                    ) {
                    if (_state.value.weightValue.length <= 2 && number != "." && number != "C"){
                        _state.update {
                            it.copy(
                                weightValue = _state.value.weightValue + number,
                                weightValueStage = WeightValueStage.RUNNING
                            )
                        }
                    }else if (number == "."){
                        _state.update {
                            it.copy(
                                weightValue = _state.value.weightValue + number,
                                weightValueStage = WeightValueStage.RUNNING
                            )
                        }
                    }else if (_state.value.weightValue.contains(".")
                        && _state.value.weightValue.reversed().indexOf(".") < 2
                        ){
                        _state.update {
                            it.copy(
                                weightValue = _state.value.weightValue + number,
                                weightValueStage = WeightValueStage.RUNNING
                            )
                        }
                    }
                }
            }

            _state.value.heightValueStage == HeightValueStage.ACTIVE -> {
                _state.update {
                    it.copy(
                        heightValue = when(number){
                            "." -> "0"
                            "C" -> "0"
                            else -> number
                        },
                        heightValueStage = HeightValueStage.RUNNING
                    )
                }
            }
            _state.value.heightValueStage == HeightValueStage.RUNNING -> {
                if (_state.value.heightValue.contains(".").not()
                    && _state.value.heightValue.contains("C").not()
                    && _state.value.heightValue.length <= 3
                ) {
                    if (_state.value.heightValue.length <= 2 && number != "." && number != "C"){
                        _state.update {
                            it.copy(
                                heightValue = _state.value.heightValue + number,
                                heightValueStage = HeightValueStage.RUNNING
                            )
                        }
                    }else if (number == "."){
                        _state.update {
                            it.copy(
                                heightValue = _state.value.heightValue + number,
                                heightValueStage = HeightValueStage.RUNNING
                            )
                        }
                    }else if (_state.value.heightValue.contains(".")
                        && _state.value.heightValue.reversed().indexOf(".") < 2
                    ){
                        _state.update {
                            it.copy(
                                heightValue = _state.value.heightValue + number,
                                heightValueStage = HeightValueStage.RUNNING
                            )
                        }
                    }
                }
            }


        }
    }

    private fun weightAndHeightUnitChange(sheetItem: String) {
        if (_state.value.sheetTitle == "Weight") {
            _state.update {
                it.copy(
                    weightUnit = sheetItem
                )
            }
        } else if (_state.value.sheetTitle == "Height") {
            _state.update {
                it.copy(
                    heightUnit = sheetItem
                )
            }
        }
    }

}