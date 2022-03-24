package com.wolfyer.firsttest

import android.app.Activity
import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import com.wolfyer.firsttest.data.GameDatabase
import com.wolfyer.firsttest.data.Record
import com.wolfyer.firsttest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        //做完Entity Dao Database 既可以 從程式當中得到Database 再從Database得到Dao 在呼叫我們所設計的發法去insert 查詢他
        //Room test
        val database = Room.databaseBuilder(this,GameDatabase::class.java,"game.db")
            .build()
        //game.db 手機裡面所使用的檔案名稱 自己取 之後必須呼叫build()才會產生出你要的這一個GameDatabase物件
        val record = Record("Jack",3)
        Thread() {
            database.recordDao().insert(record)
        }.start()
        //Terminal指令
        /*
        先看你的SDK在哪裏 File >> Project Structure >> SDK Location
        打指令： cd /Users/class/Library/Android/sdk
                cd platform-tools
                adb看可不可以用 sudo adb
                adb shell  可以連到模擬器當中
                裡面是小型linux系統
                su(google play有的話不能用
                cd /data/data/com.XXXXXX
                cd shared_prefs
                ls
                cat XXX.xml可以看裡面的資料
        */
        //singleton GameDatabase
        //上面可以改成
        val record2 = Record("nick",200)
        Thread{
            GameDatabase.getInstance(this)?.recordDao()?.insert(record2)
        }.start()
        //read test 使用 android 的 AsyncTask 避免在UI Thread 上
        AsyncTask.execute {
            val list = GameDatabase.getInstance(this)?.recordDao()?.getAll()
            list?.forEach{
                Log.d("read record", "record: ${it.nickname},${it.count}")
            }
        }
        binding.bMain2.setOnClickListener {
            val intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }





    }
}