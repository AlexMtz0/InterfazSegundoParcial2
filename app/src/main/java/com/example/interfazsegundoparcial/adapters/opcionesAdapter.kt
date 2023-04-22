package com.example.interfazsegundoparcial.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.interfazsegundoparcial.MainActivity
import com.example.interfazsegundoparcial.R
import com.example.interfazsegundoparcial.models.Opciones
import org.w3c.dom.Text

class opcionesAdapter(opcion: ArrayList<Opciones>, context: Context): RecyclerView.Adapter<opcionesAdapter.ContenedorDeVista>() {
    var inner_opcion: ArrayList<Opciones>  = opcion

    inner class ContenedorDeVista(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        val ivImagen: ImageView
        val tvTitulo: TextView

        init {
            // Define click listener for the ViewHolder's View.
            ivImagen = view.findViewById(R.id.ivImagen)
            tvTitulo = view.findViewById(R.id.tvTitulo)
            ivImagen.setOnClickListener(this)
            tvTitulo.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            if (tvTitulo.text.toString() == "Cerrar") {
                // Cerrar la aplicación
                ActivityCompat.finishAffinity(itemView.context as MainActivity)
            }
        }
    }

    override fun getItemCount(): Int {
        return inner_opcion.size
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ContenedorDeVista {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.opciones, viewGroup, false)

        return ContenedorDeVista(view)
    }

    override fun onBindViewHolder(viewHolder: ContenedorDeVista, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val op: Opciones = inner_opcion.get(position)
        viewHolder.ivImagen.setImageResource(inner_opcion.get(position).imagen)
        viewHolder.tvTitulo.text = op.opcion
    }



}