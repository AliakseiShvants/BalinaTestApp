package com.shvants.database.koin

import androidx.room.Room
import com.shvants.database.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            AppDatabase::class.java,
            "TEST_APP"
        )
            .fallbackToDestructiveMigration()
            .build()
    }
    single { get<AppDatabase>().commentDao() }
    single { get<AppDatabase>().imageDao() }
    single { get<AppDatabase>().userDao() }
}