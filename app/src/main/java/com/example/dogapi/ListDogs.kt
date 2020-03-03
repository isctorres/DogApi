package com.example.dogapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

class ListDogs : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_dogs)

        val intFinder = this.intent
        var raza = intFinder.getStringExtra("RAZA").toLowerCase()
        RequestVolley("https://dog.ceo/api/breed/"+raza+"/images")
    }

    private fun RequestVolley(url: String) {
        val queue = Volley.newRequestQueue(this)
        val solicitud = StringRequest(Request.Method.GET, url, Response.Listener<String> {
                response ->
            try {
                val gson = Gson()
                val listDogs = gson.fromJson(response,Array<Dogs>::class.java).asList()
            } catch (e: Exception) {

            }
        }, Response.ErrorListener {  })
        queue.add(solicitud)
    }
}
