package com.example.andreavillacis.examen_android

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_crear_conductor.*
import java.util.*

class crear_conductorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_conductor)

        button_crear_conductor.setOnClickListener{view: View -> Crear_conductor()}
    }

    fun Crear_conductor (){
        //val nombre = editText_nombre.text.toString()
        //val apellido = editText_apellido.text.toString()
        //val fechanacimiento = editText_fechanacimiento.text.toString()
        //val numeroauto = editText_numeroautos.text.toString()
        //val licenciavalida = editText_licencia_valida.text.toString()
        //Factory.conductor_per.add(conductor(nombre,apellido,fecha_nacimiento = Date(),numeroAutos = 656,licenciaValida = true))
        irActividadListar()
    }
    fun irActividadListar(){
        val intent =Intent(this, Listar_conductoresActivity::class.java)
        startActivity(intent)
    }


}
