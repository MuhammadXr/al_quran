package com.rast.alquran.di

import com.rast.alquran.repository.QuranRepository
import com.rast.alquran.repository.impl.QuranRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun bindRep(impl: QuranRepositoryImpl): QuranRepository
}