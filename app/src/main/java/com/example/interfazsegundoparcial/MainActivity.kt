package com.example.interfazsegundoparcial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.interfazsegundoparcial.adapters.opcionesAdapter
import com.example.interfazsegundoparcial.models.Opciones

class MainActivity : AppCompatActivity() {
    private lateinit var rvListado: RecyclerView
    private lateinit var listaOpciones: ArrayList<Opciones>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        poblarLista()
        rvListado = findViewById(R.id.rvListado)

        val CANTIDAD_COLUMNAS = 2
        var administradorDeLayouts =  LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        administradorDeLayouts =  LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        administradorDeLayouts = GridLayoutManager(this,CANTIDAD_COLUMNAS)
        rvListado.layoutManager = administradorDeLayouts //Lo ponemos en un grid (tabla) de dos columnas)
        rvListado.adapter = opcionesAdapter(listaOpciones, this) //Enviamos al adaptder la información del array


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.wificon, menu)

        supportActionBar?.setDisplayShowHomeEnabled(false)

        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.baseline_wifi_24)
        return true
    }

    private fun poblarLista(){
        listaOpciones = ArrayList()
        val texto = arrayOf<String>("Gatos","Perfil","Configurar","Cerrar")
        val imagen = arrayOf<Int>(R.drawable.cat,R.drawable.profile,R.drawable.config,R.drawable.close)
        for (i in texto.indices){
            listaOpciones.add(Opciones(texto[i],imagen[i]))
        }
    }

}