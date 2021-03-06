package com.example.andreavillacis.examen_android

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_detalle.*
import java.util.*
import kotlin.collections.ArrayList

class DetalleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        var autos= ArrayList<Auto>()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)

        val layoutManager = LinearLayoutManager(this)
        autos= FactoryAuto.auto
        val adaptador2 = AutoAdaptador(autos)
        recycler_detalle.layoutManager=layoutManager
        recycler_detalle.itemAnimator=DefaultItemAnimator()
        recycler_detalle.adapter=adaptador2
        adaptador2.notifyDataSetChanged()


       /* text_nombre.text=getIntent().getExtras().getString("nombre")
        text_apellido.text=getIntent().getExtras().getString("apellido")
        text_fecha_nacimiento.text=getIntent().getExtras().getString("fecha")
        text_numero_autos.text=getIntent().getExtras().getString("autos")
        text_licencia.text=getIntent().getExtras().getString("licencia")*/
    }
}class Auto(var chasis:Int,
           var nombreMarca:String,
           var colorUno:String,
           var colorDos:String,
           var nombreModelo:String,
           var anio:Int,
           var idConductor:Int ){}

class FactoryAuto(){
    companion object {

        var auto: ArrayList<Auto> = ArrayList()

        init {
            auto.add(Auto(1,"Chevrolet","negro","gris", "sail",2015,1))
            auto.add(Auto(1,"Hyunday","azul","blanco", "cerato",2016,2))
        }
    }
}

class AutoAdaptador(private val listaAutos: List<Auto>): RecyclerView.Adapter<AutoAdaptador.MyViewHolder>(){

    inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        var Anio: TextView
        var nombremarca:TextView
        var nombremodelo: TextView
        lateinit var carros: Auto
        var botonDetalle: Button

        init {
            nombremodelo = view.findViewById(R.id.text_nombre) as TextView
            nombremarca= view.findViewById(R.id.textView_numero_auto) as TextView
            Anio = view.findViewById(R.id.text_apellido) as TextView
            botonDetalle =view.findViewById(R.id.button_detalle) as Button
        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val muchosautos = listaAutos[position]
        holder.nombremodelo.setText(muchosautos.nombreModelo)
        holder.nombremarca.setText(muchosautos.nombreMarca)
        val anios=muchosautos.anio.toString()
        holder.Anio.setText(anios)
        holder.botonDetalle.setBackgroundColor(Color.GRAY)

    }

    override fun getItemCount(): Int {
        return listaAutos.size

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder  {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.listar_conductores2,parent,false)
        return MyViewHolder(itemView)
    }

}