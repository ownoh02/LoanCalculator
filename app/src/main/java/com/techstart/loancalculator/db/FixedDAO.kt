package com.techstart.loancalculator.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FixedDAO {

    @Insert
    suspend fun insertResult(result: FixedResult)

    @Delete
    suspend fun deleteResult(result: FixedResult)

    @Query("DELETE FROM fixed_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM fixed_table")
    fun getResults(): Flow<List<FixedResult>>

}