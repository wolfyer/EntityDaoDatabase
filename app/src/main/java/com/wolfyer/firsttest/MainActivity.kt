package com.wolfyer.firsttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wolfyer.firsttest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


    }
}