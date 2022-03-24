package com.wolfyer.firsttest.data

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//處理Room類別庫的package 下 Record 想儲存猜數字的紀錄
// 要儲存到資料庫的類別標的 Entity->把它想成要儲存到資料庫的物品物件 對象
//上頭要做一個標示語法@Entity 記得是androidx.room的

@Entity
class Record(
    @NonNull  //希望他不是null
    @ColumnInfo(name = "nick")//名稱太長 名稱標示 叫做：“”
    var nickname:String,
    @NonNull
    var count:Int){//猜數字的紀錄
    //要儲存到資料庫的類別標地叫entity物品物件對象
    //未來設計要儲存的屬性資料
    @PrimaryKey(autoGenerate = true) //主鍵值自動儲存 自動新增
    var id:Long = 0
}

@Entity //另一個案例 比如背英文單字  它的意義名稱  重點０不加星號 １加星號之類 存到word表格之中
class Word{
    @PrimaryKey
    var name :String = ""
    var means:String = ""
    var star:Int = 0
}