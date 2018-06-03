package com.example.andreavillacis.examen_android

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class conductor (var nombre:String,
                 var apellido: String,
                 var fecha_nacimiento: String,
                 var numeroAutos:String,
                 var licenciaValida: String){

    override fun toString(): String {
        return "$nombre $apellido $fecha_nacimiento $numeroAutos $licenciaValida"
    }
}
