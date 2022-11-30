package com.techstart.loancalculator.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.techstart.loancalculator.CalculatorAction
import com.techstart.loancalculator.CalculatorOperation
import com.techstart.loancalculator.models.CalModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CalculatorViewModel @Inject constructor() : ViewModel() {

    private val _cals = MutableLiveData<List<CalModel>>()
    val cals : LiveData<List<CalModel>>
    get() = _cals


    var state by mutableStateOf(CalModel())

    fun onClick(click : CalculatorAction){
        when(click){
            is CalculatorAction.Number -> enterNumber(click.number)
            is CalculatorAction.Delete -> delete()
            is CalculatorAction.Clear -> state = CalModel()
            is CalculatorAction.Operation -> enterOperation(click.operation)
            is CalculatorAction.Decimal -> enterDecimal()
            is CalculatorAction.Calculate -> calculate()
        }
    }

    private fun enterOperation(operation: CalculatorOperation) {
        if(state.number1.isNotBlank()) {

            if(state.operation != null){
                calculate()
               // state = state.copy(operation = operation)
                //return
            }
            state = state.copy(operation = operation)
            //state = state.copy(operation = operation)
        }
    }

    private fun calculate() {
        val number1 = state.number1.toDoubleOrNull()
        val number2 = state.number2.toDoubleOrNull()
        if(number1 != null && number2 != null) {
            val result = when(state.operation) {
                is CalculatorOperation.Add -> number1 + number2
                is CalculatorOperation.Subtract -> number1 - number2
                is CalculatorOperation.Multiply -> number1 * number2
                is CalculatorOperation.Divide -> number1 / number2
                null -> return
            }
            state = state.copy(
                number1 = result.toString().take(15),
                number2 = "",
                operation = null
            )
        }else if (number2 == null){
            state = state.copy(
                number1 = state.number1,
                number2 = "",
                operation = null
            )
        }

        _cals.value = listOf(
            CalModel(
                number1 = state.number1,
                number2 = "",
                operation = null
            )
        )

    }

    private fun enterNumber(number: Int) {
        if(state.operation == null) {
            if(state.number1.length >= MAX_NUM_LENGTH) {
                return
            }
            state = state.copy(
                number1 = state.number1 + number
            )
            return
        }
        if(state.number2.length >= MAX_NUM_LENGTH) {
            return
        }
        state = state.copy(
            number2 = state.number2 + number
        )
    }

    private fun delete() {
        when {
            state.number2.isNotBlank() -> state = state.copy(
                number2 = state.number2.dropLast(1)
            )
            state.operation != null -> state = state.copy(
                operation = null
            )
            state.number1.isNotBlank() -> state = state.copy(
                number1 = state.number1.dropLast(1)
            )
        }
    }

    private fun enterDecimal() {
        if(state.operation == null && !state.number1.contains(".") && state.number1.isNotBlank()) {
            state = state.copy(
                number1 = state.number1 + "."
            )
            return
        } else if(!state.number2.contains(".") && state.number2.isNotBlank()) {
            state = state.copy(
                number2 = state.number2 + "."
            )
        }
    }

    companion object {
        private const val MAX_NUM_LENGTH = 8
    }

}