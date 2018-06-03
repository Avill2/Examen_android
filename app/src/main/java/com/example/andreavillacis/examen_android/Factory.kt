package com.example.andreavillacis.examen_android

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class Factory {
    companion object {
        var conductor_per:ArrayList<conductor> = ArrayList()

        init {
            conductor_per.add(conductor("Andrea", "Villacis", "18/11/1993","2","true"))
            conductor_per.add(conductor("Jared", "Nuñez", "12/04/2015","3","false"))
            conductor_per.add(conductor("Marlon", "Nuñez", "03/07/1989","4","true"))
        }

    }
}