package com.techstart.loancalculator.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object ViewModelModule {


//    @Singleton
//    @Provides
//    fun cal(): CalculatorRepository = CalculatorRepository()
}