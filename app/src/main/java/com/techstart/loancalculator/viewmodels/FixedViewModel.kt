package com.techstart.loancalculator.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.techstart.loancalculator.db.FixedResult
import com.techstart.loancalculator.db.repository.FixedRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FixedViewModel @Inject constructor(private val repository: FixedRepository) : ViewModel() {

//    fun getConversions() = listOf(
//        Conversion(1,"Pounds to Kilograms","lbs","kg",0.453592),
//        Conversion(2,"Kilograms to Pounds","kg","lbs",2.20462),
//        Conversion(3,"Yards to Meters","yd","m",0.9144),
//        Conversion(4,"Meters to Yards","m","yd",1.09361),
//        Conversion(5,"Miles to Kilometers","mi","km",1.60934),
//        Conversion(6,"Kilometers to Miles","km","mi",0.621371)
//    )

    val resultList = repository.getSavedResults()

    fun addResult(
        price: String,
        loan: String,
        year: String,
        total: String
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertResult(FixedResult(0,price,loan,year,total))
        }
    }

    fun removeResult(item: FixedResult) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteResult(item)
        }
    }

    fun clearAll() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllResults()
        }
    }


}