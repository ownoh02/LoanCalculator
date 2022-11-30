package com.techstart.loancalculator.db.repository

import com.techstart.loancalculator.db.FixedResult
import kotlinx.coroutines.flow.Flow

interface FixedRepository {
    suspend fun insertResult(result: FixedResult)
    suspend fun deleteResult(result: FixedResult)
    suspend fun deleteAllResults()
    fun getSavedResults(): Flow<List<FixedResult>>
}