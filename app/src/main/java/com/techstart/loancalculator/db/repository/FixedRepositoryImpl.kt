package com.techstart.loancalculator.db.repository

import com.techstart.loancalculator.db.FixedDAO
import com.techstart.loancalculator.db.FixedResult
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class FixedRepositoryImpl @Inject constructor(private val dao : FixedDAO) : FixedRepository {

    override suspend fun insertResult(result: FixedResult) {
        dao.insertResult(result)
    }

    override suspend fun deleteResult(result: FixedResult) {
        dao.deleteResult(result)
    }

    override suspend fun deleteAllResults() {
        dao.deleteAll()
    }

    override fun getSavedResults(): Flow<List<FixedResult>> {
        return dao.getResults()
    }
}