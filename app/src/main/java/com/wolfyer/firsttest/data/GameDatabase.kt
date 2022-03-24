package com.wolfyer.firsttest.data

import androidx.room.Database
import androidx.room.RoomDatabase

//Entity->Dao->Database
// Database 一定要是一個抽象類別 一定要繼承RoomDatabase類別 身上必須標示Database語法 裡頭要有取得Dao抽象方法 是一個實作單一物件化的設計
//是做一個 database 初始化工作

@Database(entities = arrayOf(Record::class,Word::class), version = 1)
abstract class GameDatabase :RoomDatabase(){

}