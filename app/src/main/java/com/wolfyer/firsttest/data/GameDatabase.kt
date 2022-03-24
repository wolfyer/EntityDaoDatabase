package com.wolfyer.firsttest.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//Entity->Dao->Database
// Database 一定要是一個抽象類別 一定要繼承RoomDatabase類別 身上必須標示Database語法 裡頭要有取得Dao抽象方法 是一個實作單一物件化的設計
//是做一個 database 初始化工作

@Database(entities = arrayOf(Record::class,Word::class), version = 1)
abstract class GameDatabase :RoomDatabase(){
//取得Dao抽象方法，盡量跟Dao方法一樣
    abstract fun recordDao():RecordDao
    //身上有一個方法，可以取得Dao物件

    //singleton GameDatabase
    companion object{
        private var instance :GameDatabase? = null
        fun  getInstance(context: Context):GameDatabase?{
            if (instance == null){
                instance = Room.databaseBuilder(context,GameDatabase::class.java,"game.db").build()
            }
            return instance
        }

    }

}