package com.techstart.loancalculator.ui.screen


import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.techstart.loancalculator.CalculatorAction
import com.techstart.loancalculator.CalculatorOperation
import com.techstart.loancalculator.ui.theme.LightGray
import com.techstart.loancalculator.ui.theme.MediumGray
import com.techstart.loancalculator.ui.theme.Orange
import com.techstart.loancalculator.ui.view.OtherScreen
import com.techstart.loancalculator.viewmodels.CalculatorViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
fun CalculatorScreen(
    paddingIntent: PaddingValues,
    navController: NavHostController,
    viewModel: CalculatorViewModel = viewModel()
) {
   // val mainViewModel: CalculatorViewModel by viewModels()
    val buttonSpacing = 8.dp
    //val navController = rememberNavController()
    //val coroutineScope = rememberCoroutineScope()
    Box(
        modifier = Modifier
            .padding(paddingIntent)
            .fillMaxSize()
            .background(Color.DarkGray)
            .padding(16.dp)
    ) {
        viewModel.cals.value
        val state = viewModel.state
        //coroutineScope.cancel()
        //val list = listOf("0","1","0","1","0","1")
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing),
        ) {
//            LazyColumn(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .weight(weight = 1f)
//                    .clickable {
//                        navController.navigate(OtherScreen.Screen1.route)
//
//                    },
//            ) {
//                //var i = 0
//                items((0..30).toList()) {
//                    Text(
//                        modifier = Modifier
//                            .fillMaxWidth(), text = "Detail Item $it"
//                    )
//                }
//            }

            Text(
                text =
                state.number1 + (state.operation?.symbol ?: "") + state.number2,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp)
                    .clickable {
                        navController.navigate(OtherScreen.Screen2.route)
                    },
                fontWeight = FontWeight.Light,
                fontSize = 80.sp,
                color = Color.White,
                maxLines = 2,
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    text = "AC",
                    color = LightGray,
                    modifier = Modifier
                        .aspectRatio(2f)
                        .weight(2f)
                ) {
                    viewModel.onClick(CalculatorAction.Clear)
                }
                CalculatorButton(
                    text = "Del",
                    color = LightGray,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onClick(CalculatorAction.Delete)
                }
                CalculatorButton(
                    text = "/",
                    color = Orange,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onClick(CalculatorAction.Operation(CalculatorOperation.Divide))
                }

            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    text = "7",
                    color = MediumGray,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onClick(CalculatorAction.Number(7))
                }

                CalculatorButton(
                    text = "8",
                    color = MediumGray,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onClick(CalculatorAction.Number(8))
                }

                CalculatorButton(
                    text = "9",
                    color = MediumGray,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onClick(CalculatorAction.Number(9))
                }

                CalculatorButton(
                    text = "x",
                    color = Orange,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onClick(CalculatorAction.Operation(CalculatorOperation.Multiply))
                }

            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    text = "4",
                    color = MediumGray,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onClick(CalculatorAction.Number(4))
                }

                CalculatorButton(
                    text = "5",
                    color = MediumGray,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onClick(CalculatorAction.Number(5))
                }

                CalculatorButton(
                    text = "6",
                    color = MediumGray,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onClick(CalculatorAction.Number(6))
                }

                CalculatorButton(
                    text = "-",
                    color = Orange,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onClick(CalculatorAction.Operation(CalculatorOperation.Subtract))
                }

            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    text = "1",
                    color = MediumGray,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onClick(CalculatorAction.Number(1))
                }

                CalculatorButton(
                    text = "2",
                    color = MediumGray,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onClick(CalculatorAction.Number(2))
                }

                CalculatorButton(
                    text = "3",
                    color = MediumGray,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onClick(CalculatorAction.Number(3))
                }

                CalculatorButton(
                    text = "+",
                    color = Orange,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onClick(CalculatorAction.Operation(CalculatorOperation.Add))
                }

            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    text = "0",
                    color = MediumGray,
                    modifier = Modifier
                        .aspectRatio(2f)
                        .weight(2f)
                ) {
                    viewModel.onClick(CalculatorAction.Number(0))
                }

                CalculatorButton(
                    text = ".",
                    color = MediumGray,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onClick(CalculatorAction.Decimal)
                }

                CalculatorButton(
                    text = "=",
                    color = Orange,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onClick(CalculatorAction.Calculate)
                }


            }
        }
    }

}
