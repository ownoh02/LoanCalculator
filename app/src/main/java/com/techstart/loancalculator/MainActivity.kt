package com.techstart.loancalculator

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController

import com.techstart.loancalculator.ui.theme.LoanCalculatorTheme
import com.techstart.loancalculator.ui.view.BottomBar
import com.techstart.loancalculator.ui.view.BottomNavGraph
import com.techstart.loancalculator.ui.view.MainContent
import com.techstart.loancalculator.viewmodels.CalculatorViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.time.Instant
import java.time.format.DateTimeFormatter

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    //private val mainViewModel: CalculatorViewModel by viewModels()
    private val exampleLiveData = MutableLiveData("")

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onResume() {
        super.onResume()

        // Save whatever you want in your live data, this is just an example
        exampleLiveData.value = DateTimeFormatter.ISO_INSTANT.format(Instant.now())
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
//            mainViewModel.cals.observe(this,{
//                if(it != null){
//                    Log.e("TEST ",""+it.toString())
//                }
//            })
            LoanCalculatorTheme {
                val state = exampleLiveData.observeAsState()
                Log.d("EXAMPLE", "Recomposing screen - ${state.value}")
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainContent ()
                }
            }
        }
    }
}

//@Composable
//fun Greeting(name: String) {
//    Text(text = "Hello $name!")
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    LoanCalculatorTheme {
//        Greeting("Android")
//    }
//}