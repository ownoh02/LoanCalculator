package com.techstart.loancalculator.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.techstart.loancalculator.ui.theme.Purple200
import com.techstart.loancalculator.ui.theme.Purple500
import com.techstart.loancalculator.ui.theme.Teal555

@Composable
fun FixedScreen() {

        Column(modifier = Modifier
            .padding(5.dp)
            .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(modifier = Modifier.padding(10.dp),
                text = "ดอกเบี้ยคงที่",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            val tvfPrice  = inputData("จำนวนเงินที่ขอกู้","2,000,000")

            Log.e("TEST","tf "+tvfPrice.text)
            //tvfPrice.text
            //inputData("จำนวนเงินที่ขอกู้","2,000,000",tvfPrice)

//            val tvfMouth by remember {
//                mutableStateOf(TextFieldValue())
//            }
            val tvfMouth = inputData("ระยะเวลาที่ขอกู้","5")
//
//            val tvfLoan by remember {
//                mutableStateOf(TextFieldValue())
//            }
            val tvfLoan  =  inputData("อัตราดอกเบี้ย","6.75")



//            val textState1 = remember { mutableStateOf(TextFieldValue()) }
//            TextField(value = textState1.value, onValueChange ={textState1.value = it} )

        }

//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.Red),
//        contentAlignment = Alignment.Center
//    ) {
//        Text(
//            text = "SETTINGS",
//            fontSize = MaterialTheme.typography.h3.fontSize,
//            fontWeight = FontWeight.Bold,
//            color = Color.White
//        )
//    }
}

@Composable
private fun inputData(t : String , tf : String) : TextFieldValue {
    var tfValue by remember {
        mutableStateOf(TextFieldValue())
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {

//        Text(
//            modifier = Modifier.padding(10.dp),
//            text = t,
//            fontSize = 20.sp,
//            fontWeight = FontWeight.Bold,
//            color = Color.Black
//        )
        TextField(
            value = tfValue,
            onValueChange = { tfValue = it },
            label = { Text(t) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
//            leadingIcon = {
//                Icon(imageVector = Icons.Filled., contentDescription = "Icon")
//            },
            colors = TextFieldDefaults.textFieldColors(
                unfocusedIndicatorColor = Color.Transparent,
                focusedLabelColor = Purple200,
                backgroundColor = Teal555,
                cursorColor = Purple200,
                focusedIndicatorColor = Color.Transparent,
                unfocusedLabelColor = Purple200
            ),
            shape = RoundedCornerShape(15.dp)
        )
        Text(text = "ปี")

    }
    return tfValue
}

@Composable
@Preview
fun SettingsScreenPreview() {
    FixedScreen()
}