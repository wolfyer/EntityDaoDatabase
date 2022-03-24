package com.wolfyer.firsttest.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RecordDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)//同樣資料會被覆蓋的設定
    fun insert(record:Record)

    @Query("select * from record")//Query語法
    fun getAll():List<Record>//取得全部的紀錄

}