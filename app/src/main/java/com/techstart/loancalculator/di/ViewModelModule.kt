package com.techstart.loancalculator.di

import android.content.Context
import androidx.room.Room
import com.techstart.loancalculator.db.FixedDAO
import com.techstart.loancalculator.db.MyDatabase
import com.techstart.loancalculator.db.repository.FixedRepository
import com.techstart.loancalculator.db.repository.FixedRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ViewModelModule {


    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): MyDatabase {
        return Room.databaseBuilder(
            appContext,
            MyDatabase::class.java,
            "RssReader"
        ).build()
    }

    @Provides
    fun provideChannelDao(appDatabase: MyDatabase): FixedDAO {
        return appDatabase.converterDAO
    }

    @Provides
    @Singleton
    fun provideConvertRepository(dao : FixedDAO) : FixedRepository = FixedRepositoryImpl(dao)
//    @Singleton
//    @Provides
//    fun cal(): CalculatorRepository = CalculatorRepository()
}