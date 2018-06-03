package com.example.andreavillacis.examen_android

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_listar_conductores.*
import java.util.ArrayList

class Listar_conductoresActivity : AppCompatActivity() {
    var arrayconductor=ArrayList<conductor>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar_conductores)
        val layautManager = LinearLayoutManager(this)
        arrayconductor=Factory.conductor_per
        val adaptador = conductorAdaptador(arrayconductor)
        recycler_view.layoutManager = layautManager
        recycler_view.itemAnimator = DefaultItemAnimator()
        recycler_view.adapter = adaptador
        adaptador.notifyDataSetChanged()
    }
}

class conductorAdaptador(private val listaConductor: List<conductor>):RecyclerView.Adapter<conductorAdaptador.MyViewHolder> (){


    inner class MyViewHolder (view:View): RecyclerView.ViewHolder(view){
        var nombre: TextView
        var apellido: TextView
        var fechaNacimiento: TextView
        var detalle: Button
        init {
            nombre = view.findViewById(R.id.textView_nombre) as TextView
            apellido= view.findViewById(R.id.textView_apellido) as TextView
            fechaNacimiento= view.findViewById(R.id.textView_fecha) as TextView
            detalle= view.findViewById(R.id.button_detalle) as Button

            val layout = view.findViewById(R.id.relative_layout) as RelativeLayout
            layout.setOnClickListener({view -> val nombre_conductor= view.findViewById(R.id.textView_nombre) as TextView

            })
        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val conductor =listaConductor[position]
        holder.nombre.setText(conductor.nombre)
        holder.apellido.setText(conductor.apellido)
        holder.fechaNacimiento.setText(conductor.fecha_nacimiento)

        holder.detalle.setOnClickListener{view ->
            val intent = Intent(view.context, DetalleActivity::class.java)
            ContextCompat.startActivity(view.context, intent, null)
        }
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return listaConductor.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.listar_conductores2,parent,false)
        return MyViewHolder(itemView)
    }

}
