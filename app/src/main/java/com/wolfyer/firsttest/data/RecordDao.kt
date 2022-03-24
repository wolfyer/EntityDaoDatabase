package com.wolfyer.firsttest.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

//Entity設計完要設計Dao 設計要用interface +@Dao標示專用語法
//希望有什麼功能 fun insert()
//要+Room的insert 語法@Insert
@Dao
interface RecordDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)// 當有衝突的時候 同樣資料會被replace／update覆蓋的設定
    fun insert(record:Record)

    @Query("select * from record")//Query語法 查詢 跟room已經整合完畢 可以選record這個類別
    fun getAll():List<Record>//取得全部的紀錄

}