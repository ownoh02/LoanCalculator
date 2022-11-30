package com.techstart.loancalculator.models

import com.techstart.loancalculator.CalculatorOperation

data class CalModel(
    val number1: String = "",
    val number2: String = "",
    val operation: CalculatorOperation? = null
)