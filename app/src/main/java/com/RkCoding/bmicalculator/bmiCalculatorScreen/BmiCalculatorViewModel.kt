package com.RkCoding.bmicalculator.bmiCalculatorScreen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

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