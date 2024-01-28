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