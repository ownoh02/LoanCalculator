package com.techstart.loancalculator.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "fixed_table")
data class FixedResult(
//     @PrimaryKey(autoGenerate = true)
//     @ColumnInfo(name = "result_id")
//     val id : Int,
//     @ColumnInfo(name = "result_message1")
//     val messagePart1 : String,
//     @ColumnInfo(name = "result_message2")
//     val messagePart2 : String
     @PrimaryKey(autoGenerate = true)
     val id : Int,
     val price : String,
     val loan : String,
     val year : String,
     val total : String
)
