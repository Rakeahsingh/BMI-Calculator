package com.RkCoding.bmicalculator.bmiCalculatorScreen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class BmiCalculatorViewModel: ViewModel() {

    private val _state = MutableStateFlow(BmiCalculatorState())
    val state = _state.asStateFlow()



}