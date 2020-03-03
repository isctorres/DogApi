package com.example.dogapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_list_dogs.*
import kotlinx.android.synthetic.main.activity_main.*

class ListDogs : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_dogs)

        rcvListado.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        val intFinder = this.intent
        var raza = intFinder.getStringExtra("RAZA").toLowerCase()
        txtHeader.text = "Raza del Perro: "+raza
        RequestVolley("https://dog.ceo/api/breed/"+raza+"/images")
    }

    private fun RequestVolley(url: String) {
        val queue = Volley.newRequestQueue(this)
        val solicitud = StringRequest(Request.Method.GET, url, Response.Listener<String> {
                response ->
            try {
                val gson = Gson()
                val listDogs = gson.fromJson(response,Dogs::class.java)
                val adaptador = AdapterDog(listDogs.message!!)
                rcvListado.adapter = adaptador
            } catch (e: Exception) {

            }
        }, Response.ErrorListener {  })
        queue.add(solicitud)
    }
}
