package com.techstart.loancalculator.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [FixedResult::class],version = 1)
abstract class MyDatabase : RoomDatabase() {

    abstract val converterDAO : FixedDAO

}