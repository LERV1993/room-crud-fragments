package com.example.tp_room_fragments.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.tp_room_fragments.R
import com.example.tp_room_fragments.model.User

class AdapterUser(
    val listaUsuarios: MutableList<User>,
    val listener: AdapterListener
) : RecyclerView.Adapter<AdapterUser.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_usuario,parent,false)
        return ViewHolder(vista)
    }

    override fun getItemCount(): Int {
        return listaUsuarios.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val usuario = listaUsuarios[position]

        holder.tvNombre.text = usuario.name
        holder.tvEdad.text = usuario.age.toString()
        holder.tvEmail.text = usuario.email
        holder.tvLenguaje.text = usuario.lenguaje

        holder.cvUsuario.setOnClickListener {
            listener.onEditItemClick(usuario)
        }

        holder.btnBorrar.setOnClickListener {
            listener.onDeleteItemClick(usuario)
        }
    }

    inner class ViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView){
        val cvUsuario = itemView.findViewById<CardView>(R.id.cvUsuario)
        val tvNombre = itemView.findViewById<TextView>(R.id.tvNombre)
        val tvEdad = itemView.findViewById<TextView>(R.id.tvEdad)
        val tvEmail = itemView.findViewById<TextView>(R.id.tvEmail)
        val tvLenguaje = itemView.findViewById<TextView>(R.id.tvLenguaje)
        val btnBorrar = itemView.findViewById<Button>(R.id.btnBorrar)
    }
}