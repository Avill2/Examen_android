package com.example.andreavillacis.examen_android

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

class Base{
    companion object {
        val BDD_NOMBRE = "Aplicacion_Android"
        val BDD_TABLA_CONDUCTOR_NOMBRE = "conductor"
        val BDD_TABLA_CONDUCTOR_CAMPO_NOMBRE = "nombre"
        val BDD_TABLA_CONDUCTOR_CAMPO_APELLIDO = "apellido"
        val BDD_TABLA_CONDUCTOR_CAMPO_FECHANACIMIENTO = "fechanacimiento"
        val BDD_TABLA_CONDUCTOR_CAMPO_NUMEROAUTOS = "numeroautos"
        val BDD_TABLA_CONDUCTOR_CAMPO_LICENCIAVALIDA = "licenciavalida"


        /*(var nombre:String,
                           var apellido: String,
                           var fecha_nacimiento: Date?,
                           var numero_autos:Int,
                           var licencia_valida: Boolean)*/


        val BDD_TABLA_AUTO_NOMBRE = "auto"
        val BDD_TABLA_AUTO_CAMPO_IDCONDUCTOR = "id"
        val BDD_TABLA_AUTO_CAMPO_CHAIS = "chasis"
        val BDD_TABLA_AUTO_CAMPO_NOMBREMARCA = "nombreMarca"
        val BDD_TABLA_AUTO_CAMPO_COLORUNO = "coloruno"
        val BDD_TABLA_AUTO_CAMPO_COLORDOS = "colordos"
        val BDD_TABLA_AUTO_CAMPO_NOMBREMODELO = "nombreModelo"
        val BDD_TABLA_AUTO_CAMPO_ANIO = "anio"

        /*
        * var chasis:Int,
                     var nombreMarca:String,
                     var colorUno:String,
                     var colorDos:String,
                     var nombreModelo:String,
                     var anio:Int,
                     var idConductor:Int*/
    }

}

class  DbHandlerAplicacion(context: Context): SQLiteOpenHelper(context,Base.BDD_NOMBRE,null,1){
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(db: SQLiteDatabase?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

        val createTableConductor = "CREATE TABLE ${Base.BDD_TABLA_CONDUCTOR_NOMBRE} " +
                "(${Base.BDD_TABLA_CONDUCTOR_CAMPO_NOMBRE } VARCHAR(60)," +
                "${Base.BDD_TABLA_CONDUCTOR_CAMPO_APELLIDO } VARCHAR(60)," +
                "${Base.BDD_TABLA_CONDUCTOR_CAMPO_FECHANACIMIENTO }DATE," +
                "${Base.BDD_TABLA_CONDUCTOR_CAMPO_NUMEROAUTOS} INTEGER," +
                "${Base.BDD_TABLA_CONDUCTOR_CAMPO_LICENCIAVALIDA} BOOLEAN)"


        val createTableauto = "CREATE TABLE ${Base.BDD_TABLA_CONDUCTOR_NOMBRE} " +
                "(${Base.BDD_TABLA_AUTO_CAMPO_IDCONDUCTOR} INTEGER," +
                "${Base.BDD_TABLA_AUTO_CAMPO_CHAIS} INTEGER," +
                "${Base.BDD_TABLA_AUTO_CAMPO_NOMBREMARCA} VARCHAR(60)," +
                "${Base.BDD_TABLA_AUTO_CAMPO_COLORUNO} VARCHAR(10)," +
                "${Base.BDD_TABLA_AUTO_CAMPO_COLORDOS} VARCHAR(10)," +
                "${Base.BDD_TABLA_AUTO_CAMPO_NOMBREMODELO} VARCHAR(60)," +
                "${Base.BDD_TABLA_AUTO_CAMPO_ANIO} INTEGER)"

        db?.execSQL(createTableConductor)
        db?.execSQL(createTableauto)

    }
    fun insertarConductor(nombre:String,
                          apellido:String,
                          fechaNacimiento:Date,
                          numeroAutos:Int,
                          licenciaValida:Boolean){

        val dbWriteable = writableDatabase
        val crear = ContentValues()


        crear.put(Base.BDD_TABLA_CONDUCTOR_CAMPO_NOMBRE,nombre)
        crear.put(Base.BDD_TABLA_CONDUCTOR_CAMPO_APELLIDO,apellido )
        //crear.put(Base.BDD_TABLA_CONDUCTOR_CAMPO_FECHANACIMIENTO,fechaNacimiento)
        crear.put(Base.BDD_TABLA_CONDUCTOR_CAMPO_NUMEROAUTOS,numeroAutos)
        crear.put(Base.BDD_TABLA_CONDUCTOR_CAMPO_LICENCIAVALIDA,licenciaValida)

        val resul = dbWriteable.insert(Base.BDD_TABLA_CONDUCTOR_NOMBRE,null,crear)

        Log.i("database", "Si es -1 hubo error, sino exito: Respuesta: $resul")

        dbWriteable.close()


    }


    fun insertarauto(chasis:Int,
                      nombreMarca:String,
                      colorUno:String,
                      colorDos:String,
                      nombreModelo:String,
                      anio:Int,
                      idConductor:Int){

        val dbWriteable = writableDatabase
        val crear = ContentValues()



        crear.put( Base.BDD_TABLA_AUTO_CAMPO_IDCONDUCTOR,idConductor)
        crear.put(Base.BDD_TABLA_AUTO_CAMPO_CHAIS,chasis)
        crear.put(Base.BDD_TABLA_AUTO_CAMPO_NOMBREMARCA,nombreMarca)
        crear.put(Base.BDD_TABLA_AUTO_CAMPO_COLORUNO,colorUno)
        crear.put(Base.BDD_TABLA_AUTO_CAMPO_COLORDOS,colorDos)
        crear.put(Base.BDD_TABLA_AUTO_CAMPO_NOMBREMODELO,nombreModelo)
        crear.put(Base.BDD_TABLA_AUTO_CAMPO_ANIO,anio)


        val resul = dbWriteable.insert(Base.BDD_TABLA_AUTO_NOMBRE,null,crear)

        Log.i("database", "Si es -1 hubo error, sino exito: Respuesta: $resul")

        dbWriteable.close()


    }

    fun leerDatosConductor(){

        val dbReadable = readableDatabase
        val query = "SELECT * FROM ${Base.BDD_TABLA_CONDUCTOR_NOMBRE}"
        val resultado = dbReadable.rawQuery(query,null)

        if (resultado.moveToFirst()) {
            do {
                val nombreActual = resultado.getString(0)
                val IDConductor = resultado.getString(1).toInt()
                Log.i("database", "El nombre es $nombreActual con version $IDConductor")
            } while (resultado.moveToNext())
        }
        resultado.close()
        dbReadable.close()
    }

    fun toSimpleString(date: Date?) = with(date ?: Date()) {
        SimpleDateFormat("dd/MM/yyy").format(this)
    }
}





