package com.example.andreavillacis.examen_android

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_crear.setOnClickListener{view :View ->irActividadCrear()}
    }

    fun irActividadCrear(){
        val intent = Intent(this,crear_conductorActivity ::class.java )
        startActivity(intent)
    }
}
