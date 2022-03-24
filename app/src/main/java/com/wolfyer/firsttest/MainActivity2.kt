package com.wolfyer.firsttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wolfyer.firsttest.databinding.ActivityMain2Binding
import com.wolfyer.firsttest.databinding.RowFunctionBinding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding :ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMain2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //Recycler

        binding.recycler.layoutManager = LinearLayoutManager(this)
        binding.recycler.setHasFixedSize(true) //是不是要固定大小
        binding.recycler.adapter = FunctionAdapter()

    }
    inner class FunctionAdapter():RecyclerView.Adapter<FunctionHolder>(){
        val functions = listOf<String>(
                            "Camera",
                            "Invite friends",
                            "Parking",
                            "Download coupons",
                            "News",
                            "Maps"
                        )
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FunctionHolder {
            val binding = RowFunctionBinding.inflate(layoutInflater,parent,false)
            return FunctionHolder(binding)
        }

        override fun onBindViewHolder(holder: FunctionHolder, position: Int) {
            holder.nameText.text = functions.get(position)
        }

        override fun getItemCount(): Int {
            return functions.size
        }

    }
    class FunctionHolder(val binding :RowFunctionBinding) :RecyclerView.ViewHolder(binding.root){
        var nameText: TextView = binding.name
    }
}