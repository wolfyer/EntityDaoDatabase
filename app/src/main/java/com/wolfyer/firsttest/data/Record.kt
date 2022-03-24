package com.wolfyer.firsttest.data

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Record(
    @NonNull
    @ColumnInfo(name = "nick")
    var nickname:String,
    @NonNull
    var count:Int){//猜數字的紀錄
    //要儲存到資料庫的類別標地叫entity物品物件對象
    //未來設計要儲存的屬性資料
    @PrimaryKey(autoGenerate = true) //主鍵值自動儲存
    var id:Long = 0
}

@Entity
class Word{
    @PrimaryKey
    var name :String = ""
    var means:String = ""
    var star:Int = 0
}