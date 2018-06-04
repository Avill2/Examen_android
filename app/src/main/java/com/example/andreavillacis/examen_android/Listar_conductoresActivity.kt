package com.example.andreavillacis.examen_android

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_listar_conductores.*
import java.util.*

class Listar_conductoresActivity : AppCompatActivity() {
    var arrayconductor=ArrayList<conductor>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar_conductores)
        val layautManager = LinearLayoutManager(this)
        arrayconductor=conductor.Factory.conductor_per
        val adaptador = conductorAdaptador(arrayconductor)
        recycler_view.layoutManager = layautManager
        recycler_view.itemAnimator = DefaultItemAnimator()
        recycler_view.adapter = adaptador
        adaptador.notifyDataSetChanged()
    }
}


class conductor (var nombre:String,
                 var apellido: String,
                 var fecha_nacimiento: Date,
                 var numeroAutos:Int,
                 var licenciaValida: Boolean) {

    // override fun toString(): String {
    //   return "$nombre $apellido "
    //}


    class Factory {
        companion object {
            var conductor_per: ArrayList<conductor> = ArrayList()

            init {
                conductor_per.add(conductor("Andrea", "Villacis", Date(), 2, true))
                conductor_per.add(conductor("Jared", "Nuñez", Date(), 3, false))
                conductor_per.add(conductor("Marlon", "Nuñez", Date(), 4, true))
            }

        }
    }

}

class conductorAdaptador(private val listaConductor: List<conductor>):RecyclerView.Adapter<conductorAdaptador.MyViewHolder> (){

   /* override fun onMenuItemClick(item: menu): Boolean {
        when (item.getItemId()) {
            R.id.menu_editar_item -> {
                Log.i("menu", "Editar")
                return true
            }
            R.id.menu_eliminar_item -> {
                Log.i("menu", "Eliminar")
                return true
            }
            R.id.menu_correo_item -> {
                Log.i("menu", "Correo")
                return true
            }
            else -> {
                Log.i("menu", "Todos los demas")
                return false
            }
        }*/

    inner class MyViewHolder (view:View): RecyclerView.ViewHolder(view){
        var nombre: TextView
        var apellido: TextView
        var numeroauto: TextView
        lateinit var conductores:conductor
        var detalle: Button
        init {
            nombre = view.findViewById(R.id.text_nombre) as TextView
            apellido= view.findViewById(R.id.text_apellido) as TextView
            numeroauto= view.findViewById(R.id.textView_numero_auto) as TextView
            detalle= view.findViewById(R.id.button_detalle) as Button

            val layout = view.findViewById(R.id.relative_layout) as RelativeLayout
            layout.setOnClickListener({view ->

            })
        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val conductor =listaConductor[position]
        holder.nombre.setText(conductor.nombre)
        holder.apellido.setText(conductor.apellido)
        val numauto=conductor.numeroAutos.toString()
        holder.numeroauto.setText(numauto)


        holder.detalle.setOnClickListener{view ->
            val intent = Intent(view.context, DetalleActivity::class.java)
            ContextCompat.startActivity(view.context, intent, null)
        }
    }

    override fun getItemCount(): Int {
        return listaConductor.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.listar_conductores2,parent,false)
        return MyViewHolder(itemView)
    }

}
