package com.example.l9_homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import java.text.FieldPosition

class MainActivity : AppCompatActivity() {

    private var tvCityName : TextView? = null
    private var spCity : Spinner? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        setupSpinner()
        setupListeners()
    }

    private fun initView(){
        tvCityName = findViewById(R.id.tvMsg)
        spCity = findViewById(R.id.spCities)
    }

    private  fun setupSpinner (){
        val adapter = ArrayAdapter.createFromResource(this, R.array.cities, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spCity?.adapter = adapter
    }

    private fun setupListeners (){
        spCity?.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected (parent : AdapterView<*>, view : View, position: Int, id:Long){
                val items = parent.getItemAtPosition(position).toString()
                tvCityName?.setText(items)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) { }

        }
    }


}