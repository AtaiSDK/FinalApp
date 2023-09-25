package com.example.finalapp.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.finalapp.data.db.HouseDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DIModule {

        @Singleton
        @Provides
        fun provideRoomDataBase(
            @ApplicationContext context: Context
        ){
            Room.databaseBuilder(
                context = context,
                klass = HouseDataBase::class.java,
                "house_data_base"
            ).build()
        }

    @Provides
    fun provideDoorDao(
        roomDatabase: HouseDataBase
    ){
        roomDatabase.getDoorDao()
    }



    @Provides
    fun provideCameraDao(
        roomDatabase: HouseDataBase
    ){
        roomDatabase.getCameraDao()
    }

}